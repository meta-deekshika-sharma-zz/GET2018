package storeFront;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class InsertInBatch {

	public static void insertBatch(List<ImagePojo> imageList) {
		String insertImage = "insert into Image (Url, Text, ProductId) values(?,?,?)";
		
		try(Connection conn = StoreFrontUtility.getConnection();
			PreparedStatement 	statement = conn.prepareStatement(insertImage);
			)
		{
			conn.setAutoCommit(false);
			
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
