package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.metacube.training.model.Employee;

/**
 * @author Deekshika Sharma
 * This class will work for editing employee database
 */
public class EditEmployeeDAO implements EmployeeProfileDAO<Employee> {

	@Override
	public int createField(Employee t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateField(Employee employee) {

		String query = "UPDATE Employee SET first_name = ?, middle_name = ?, last_name = ?,"
				+ " dob = ?, primary_contact_no = ?, secondary_contact_no = ?, email_id = ?, skype_id = ?, password = ? WHERE emp_code = ?";
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getMiddleName());
			statement.setString(3, employee.getLastName());
			statement.setDate(4, new Date(employee.getDob().getTime()));
			statement.setString(5, employee.getGender());
			statement.setString(5, employee.getPrimaryContactNo());
			statement.setString(6, employee.getSecondaryContactNo());
			statement.setString(7, employee.getEmailId());
			statement.setString(8, employee.getSkypeId());
			statement.setBlob(10, employee.getProfilePicture());
			statement.setString(9, employee.getPassword());
			System.out.println(employee.getCode());
			statement.setString(10, employee.getCode());
			System.out.println("executed");
			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteField(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> getField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getFieldById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
