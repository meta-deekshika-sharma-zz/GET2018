package com.metacube.training.dao;

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
 * This class will have database access for search employee
 */
public class SearchEmployeeDAO {

	public List<Employee> searchByName(String employeeName) {
		List<Employee> employeeList = new ArrayList<Employee>();
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(SearchQuery.SEARCH_BY_NAME);) {
			statement.setString(1, employeeName);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setCode(resultSet.getString("emp_code"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setMiddleName(resultSet.getString("middle_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setDob(new Date(resultSet.getDate("dob").getTime()));
				employee.setEmailId(resultSet.getString("email_id"));
				employee.setSkypeId(resultSet.getString("skype_id"));
				employee.setPrimaryContactNo(resultSet
						.getString("primary_contact_no"));
				employee.setSecondaryContactNo(resultSet
						.getString("secondary_contact_no"));

				employeeList.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	public List<Employee> searchByProject(int project_id) {
		List<Employee> employeeList = new ArrayList<Employee>();
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(SearchQuery.SEARCH_BY_PROJECT);) {
			statement.setInt(1, project_id);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setCode(resultSet.getString("emp_code"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setMiddleName(resultSet.getString("middle_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setDob(new Date(resultSet.getDate("dob").getTime()));
				employee.setEmailId(resultSet.getString("email_id"));
				employee.setSkypeId(resultSet.getString("skype_id"));
				employee.setPrimaryContactNo(resultSet
						.getString("primary_contact_no"));
				employee.setSecondaryContactNo(resultSet
						.getString("secondary_contact_no"));

				employeeList.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	public List<Employee> searchBySkill(int skill_id) {
		List<Employee> employeeList = new ArrayList<Employee>();
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(SearchQuery.SEARCH_BY_SKILL);) {
			statement.setInt(1, skill_id);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setCode(resultSet.getString("emp_code"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setMiddleName(resultSet.getString("middle_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setDob(new Date(resultSet.getDate("dob").getTime()));
				employee.setEmailId(resultSet.getString("email_id"));
				employee.setSkypeId(resultSet.getString("skype_id"));
				employee.setPrimaryContactNo(resultSet
						.getString("primary_contact_no"));
				employee.setSecondaryContactNo(resultSet
						.getString("secondary_contact_no"));

				employeeList.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	public List<Employee> searchByTotalExperience(Double total_exp) {
		List<Employee> employeeList = new ArrayList<Employee>();
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(SearchQuery.SEARCH_BY_TOTAL_EXP);) {
			statement.setDouble(1, total_exp);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setCode(resultSet.getString("emp_code"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setMiddleName(resultSet.getString("middle_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setDob(new Date(resultSet.getDate("dob").getTime()));
				employee.setEmailId(resultSet.getString("email_id"));
				employee.setSkypeId(resultSet.getString("skype_id"));
				employee.setPrimaryContactNo(resultSet
						.getString("primary_contact_no"));
				employee.setSecondaryContactNo(resultSet
						.getString("secondary_contact_no"));

				employeeList.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}
}
