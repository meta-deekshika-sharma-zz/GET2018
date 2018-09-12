package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Deekshika Sharma
 * This class will have queries for database connectivity
 */
public class JDBCConnection {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			System.out.println("in connection");
			Class.forName("com.mysql.jdbc.Driver"); // initializes the driver of
													// mysql
			String url = "jdbc:mysql://localhost:3306/employeePortal"; // get
																		// url
																		// of
																		// database
			conn = DriverManager.getConnection(url, "root", "deekshika");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(2);
		}
		return conn;
	}
}
