package storeFront;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Deekshika Sharma
 * This class will have helper method for getting connection through database
 */
public class StoreFrontUtility {
	
	  public static Connection getConnection()
	  {
	    Connection conn = null;
	    try
	    {
	      Class.forName("com.mysql.jdbc.Driver"); // initializes the driver of mysql
	      String url = "jdbc:mysql://localhost:3306/store_front"; // get url of database
	      conn = DriverManager.getConnection(url, "root", "deekshika");
	    }
	    catch (ClassNotFoundException e)
	    {
	      e.printStackTrace();
	      System.exit(1);
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      System.exit(2);
	    }
	    return conn;
	  }
	  
}
