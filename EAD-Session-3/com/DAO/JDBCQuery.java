package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.EmployeeDAO;

public class JDBCQuery {

	public static int insertEmployeeData(EmployeeDAO employee)
	{
		String addData = "INSERT INTO Employee(firstName, lastName, email, age) VALUES(?, ?, ?, ?)";
		
		try(Connection conn = JDBCConnection.getConnection();
				PreparedStatement 	statement = conn.prepareStatement(addData);
				)
			{
				statement.setString(1, employee.getFirstName());
				statement.setString(2, employee.getLastName());
				statement.setString(3, employee.getEmail());
				statement.setInt(4, employee.getAge());
				
				return statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return 0;
	}
	
	public static List<EmployeeDAO> showEmployeeData()
	{
		List<EmployeeDAO> employeeList = new ArrayList<EmployeeDAO>();
		String searchData = "SELECT firstName, lastName, email, age FROM Employee";
		
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement 	statement = conn.prepareStatement(searchData);)
		{
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				String firstNameResult = resultSet.getString("firstName");
				String lastNameResult = resultSet.getString("lastName");
				String email = resultSet.getString("email");
				int age = resultSet.getInt("age");
				
				employeeList.add(new EmployeeDAO(firstNameResult, lastNameResult, email, age));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return employeeList;
	}
	
	public static List<EmployeeDAO> searchEmployeeData(String name)
	{
		List<EmployeeDAO> employeeList = new ArrayList<EmployeeDAO>();
		String searchData = "SELECT firstName, lastName, email, age FROM Employee WHERE concat(firstName,'',lastName) LIKE concat('%', ?, '%') OR concat(lastName,'', firstName) LIKE concat('%', ?, '%')";
		
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(searchData);)
		{	
			statement.setString(1, name);
			statement.setString(2, name);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				String firstNameResult = resultSet.getString("firstName");
				String lastNameResult = resultSet.getString("lastName");
				String email = resultSet.getString("email");
				int age = resultSet.getInt("age");
				
				employeeList.add(new EmployeeDAO(firstNameResult, lastNameResult, email, age));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}
	
	public static int updateEmployeeData(EmployeeDAO employee, String oldEmail)
	{
		String updateData = "UPDATE Employee SET firstName = ?, lastName = ?, email = ?, age = ? WHERE email = ?";
		
		try (Connection conn = JDBCConnection.getConnection();
			PreparedStatement statement = conn.prepareStatement(updateData);)
		{	
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getEmail());
			statement.setInt(4, employee.getAge());
			statement.setString(5, oldEmail);
			
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
