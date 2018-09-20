package com.metacube.training.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.training.model.Employee;

/**
 * @author Deekshika Sharma
 * This class will provide dabase access for employees
 */
public class EmployeeDAO implements AdminDAO<Employee> {

	@Override
	public int createField(Employee employee) {
		return 0;
	}

	@Override
	public int updateField(Employee employee) {
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(EmployeeQuery.UPDATE_EMPLOYEE);) {
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getMiddleName());
			statement.setString(3, employee.getLastName());
			statement.setDate(4, new Date(employee.getDob().getTime()));
			// statement.setString(5, employee.getGender());
			statement.setString(5, employee.getPrimaryContactNo());
			statement.setString(6, employee.getSecondaryContactNo());
			statement.setString(7, employee.getEmailId());
			statement.setString(8, employee.getSkypeId());
			// statement.setBlob(10, employee.getProfilePicture());
			// statement.setString(9, employee.getPassword());
			System.out.println(employee.getCode());
			statement.setString(9, employee.getCode());
			System.out.println("executed");
			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteField(String id) {
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(EmployeeQuery.DELETE_EMPLOYEE);) {
			statement.setBoolean(1, false);
			statement.setString(2, id);

			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Employee> getField() {

		List<Employee> employees = new ArrayList<Employee>();
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(EmployeeQuery.GET_EMPLOYEE_LIST);) {
			statement.setBoolean(1, true);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				System.out.println("found");
				Employee employee = new Employee();

				employee.setCode(resultSet.getString("emp_code"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setMiddleName(resultSet.getString("middle_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setDob(resultSet.getDate("dob"));
				employee.setGender(resultSet.getString("gender"));
				employee.setPrimaryContactNo(resultSet
						.getString("primary_contact_no"));
				employee.setSecondaryContactNo(resultSet
						.getString("secondary_contact_no"));
				employee.setEmailId(resultSet.getString("email_id"));
				employee.setSkypeId(resultSet.getString("skype_id"));

				Blob blob = resultSet.getBlob("profile_picture");
				
				if(blob == null)
					employee.setProfilePicture(null);
				else
					employee.setProfilePicture(blob.getBinaryStream());
				employees.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee getFieldById(String id) {
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(EmployeeQuery.GET_EMPLOYEE_BY_CODE);) {
			statement.setString(1, id);
			statement.setBoolean(2, true);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Employee employee = new Employee();

				employee.setCode(resultSet.getString("emp_code"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setMiddleName(resultSet.getString("middle_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setDob(resultSet.getDate("dob"));
				employee.setGender(resultSet.getString("gender"));
				employee.setPrimaryContactNo(resultSet
						.getString("primary_contact_no"));
				employee.setSecondaryContactNo(resultSet
						.getString("secondary_contact_no"));
				employee.setEmailId(resultSet.getString("email_id"));
				employee.setSkypeId(resultSet.getString("skype_id"));

				Blob blob = resultSet.getBlob("profile_picture");
				if(blob == null)
					employee.setProfilePicture(null);
				else
					employee.setProfilePicture(blob.getBinaryStream());
				return employee;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean isValidAdminLogin(String username, String password) {
		if ("admin".equals(username) && "admin".equals(password))
			return true;
		return false;
	}

	public boolean isEmailAvailable(String email) {
		String query = "SELECT email_id from Employee WHERE email_id = ?";
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setString(1, email);

			if (statement.executeQuery().next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public String getCodeByEmail(String email) {
		String query = "SELECT emp_code from Employee WHERE email_id = ?";
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setString(1, email);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next())
				return resultSet.getString("emp_code");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean isValidEmployeeLogin(String username, String password) {
		String query = "SELECT email_id from Employee WHERE emp_code = ? AND password = ?";
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
}
