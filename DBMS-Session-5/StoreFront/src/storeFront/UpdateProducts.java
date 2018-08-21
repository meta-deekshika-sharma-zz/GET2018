package storeFront;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProducts {

	public static int deleteProducts()
	{
        String insertImage = "SET SQL_SAFE_UPDATES = 0;"
        		+ "UPDATE Product SET ProductStatus = 'Inactive' "
        		+ "WHERE Id NOT IN (SELECT opr.ProductId FROM OrderProductRelation opr INNER JOIN Orders o ON o.Id = opr.OrderId"
        		+ "WHERE o.PlacedDate >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR));";
		
		try(Connection conn = StoreFrontUtility.getConnection();
			PreparedStatement 	statement = conn.prepareStatement(insertImage);
			)
		{
			return statement.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
