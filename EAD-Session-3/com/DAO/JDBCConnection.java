package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	 public static Connection getConnection()
	  {
	    Connection conn = null;
	    try
	    {
	      Class.forName("com.mysql.jdbc.Driver"); // initializes the driver of mysql
	      String url = "jdbc:mysql://localhost:3306/employeeData"; // get url of database
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
