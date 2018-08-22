package storeFront;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Deekshika Sharma
 * This class will have the basic JDBC Queries to perform operations on Store Front 
 */
public class JDBCQuery {
  
	private int count;
	/**
	 * This method will insert the images in batch format
	 * @param imageList
	 * @return true if all images insert successfully
	 */
	public static boolean insertImageBatch(List<ImagePojo> imageList) {
		String insertImage = "insert into Image (Url, Text, ProductId) values(?,?,?)";
		
		try(Connection conn = StoreFrontUtility.getConnection();
			PreparedStatement 	statement = conn.prepareStatement(insertImage);
			)
		{
			conn.setAutoCommit(false); // set auto commit to false
			
			for(ImagePojo imagePojo: imageList)
			{
				statement.setString(1, imagePojo.getUrl());
				statement.setString(2, imagePojo.getText());
				statement.setInt(3, imagePojo.getProductId());
				statement.addBatch();
			}

			int[] result = statement.executeBatch();
			System.out.println("The number of rows inserted: " + result.length);
			conn.commit();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
 	
	/**
	 * This method will select orders and return into list format
	 * @param userId
	 * @return
	 */
	public static List<OrderPojo> selectOrders(int userId) {
		
		List<OrderPojo> orderList = new ArrayList<OrderPojo>();
		String selectOrder = "select o.Id, o.PlacedDate, SUM(op.Quantity * p.Price) AS amount "
				+ "from OrderProduct AS op INNER JOIN Orders AS o ON op.OrderId = o.Id "
				+ "INNER JOIN Product AS p ON p.Id = op.ProductId "
				+ "WHERE op.Status = 'Shipped' AND o.UserId = '"+userId+"'"
				+ " GROUP BY o.Id "
				+ "ORDER BY o.PlacedDate DESC";
		
		try (Connection conn = StoreFrontUtility.getConnection();
			 PreparedStatement 	statement = conn.prepareStatement(selectOrder);
			)
		{
			ResultSet rset = statement.executeQuery();
			while(rset.next())
			{				
				int id = rset.getInt("o.Id");
				Date PlacedDate = rset.getDate("o.PlacedDate");
				Double amount = rset.getDouble("amount");
				
				OrderPojo orderPojo = new OrderPojo(id, PlacedDate, amount);
				
				orderList.add(orderPojo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderList;
	}
	
	/**
	 * This method will update the status of the products
	 * @return
	 */
	public static int updateProducts()
	{
        String insertImage = "SET SQL_SAFE_UPDATES = 0;"
        		+ "UPDATE Product SET ProductStatus = 'Inactive' "
        		+ "WHERE Id NOT IN (SELECT op.ProductId FROM OrderProduct op INNER JOIN Orders o ON o.Id = op.OrderId"
        		+ "WHERE o.PlacedDate >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR));";
		
		try(Connection conn = StoreFrontUtility.getConnection();
			PreparedStatement statement = conn.prepareStatement(insertImage);
			)
		{
			return statement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * This method will display the list of sub categories of top category
	 * @return
	 */
	public List<TopCategory> getTopCategoryWithChildrenCount()
    {
        List<TopCategory> parentCategoryList =new ArrayList<TopCategory>();
        
        String query = "SELECT Id, Name " + 
                       "FROM Category " + 
                       "WHERE parentCategoryId = '0' " + 
                       "ORDER BY Name";
        
        try
        (
                Connection conn = StoreFrontUtility.getConnection();
                PreparedStatement statement = conn.prepareStatement(query);
        )
        {
            ResultSet topCategories = statement.executeQuery();
            while(topCategories.next())
            {
            	count = 0;
                int topCategoryID = topCategories.getInt("Id");
                String topCategoryName = topCategories.getString("Name");
                
                int subCategoriesCount = countSubCategories(topCategoryID);
                TopCategory category = new TopCategory(topCategoryName, subCategoriesCount);
                parentCategoryList.add(category);
            }
        } 
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return parentCategoryList;
    }
    
	/**
	 * This helper method method will count the sub categories
	 * @param categoryID
	 * @return
	 */
    private int countSubCategories(int categoryID)
    {
        String subCategoriesQuery = "SELECT Id, Name " + 
                "FROM Category " + 
                "WHERE ParentCategoryId = ?";

        try(
                Connection conn = StoreFrontUtility.getConnection();
                PreparedStatement subCategoriesStatement = conn.prepareStatement(subCategoriesQuery);
        )
        {
            subCategoriesStatement.setInt(1, categoryID);
            ResultSet subCategoriesSet = subCategoriesStatement.executeQuery();
            
            while(subCategoriesSet.next())
            {
                int subCategoryID = subCategoriesSet.getInt("Id");
                count = count + 1;
                countSubCategories(subCategoryID); 
            }
         
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }

        return count;
    }
}
