package storeFront;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectOrders {

	public static List<OrderPojo> selectOrders(int userId) {
		
		List<OrderPojo> orderList = new ArrayList<OrderPojo>();
		String selectOrder = "select o.Id, o.PlacedDate, SUM(opr.Quantity * p.Price) AS amount "
				+ "from OrderProductRelation AS opr INNER JOIN Orders AS o ON opr.OrderId = o.Id "
				+ "INNER JOIN Product AS p ON p.Id = opr.ProductId "
				+ "WHERE opr.Status = 'Shipped' AND o.UserId = '"+userId+"'"
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
				
				OrderPojo orderPojo = new OrderPojo();
				orderPojo.setId(id);
				orderPojo.setPlacedDate(PlacedDate);
				orderPojo.setTotalAmount(amount);
				
				orderList.add(orderPojo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderList;
	}
}
