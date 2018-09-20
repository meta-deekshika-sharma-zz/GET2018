package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Employee;

/**
 * @author Deekshika Sharma 
 * This class will work for editing employee database
 */
@Repository
public class EditEmployeeDAO implements EmployeeProfileDAO<Employee> {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EditEmployeeDAO(javax.sql.DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	private final String UPDATE_EMPLOYEE = "UPDATE Employee SET first_name = ?, middle_name = ?, last_name = ?,"
			+ " dob = ?, primary_contact_no = ?, secondary_contact_no = ?, email_id = ?, skype_id = ?, password = ? WHERE emp_code = ?";

	@Override
	public int createField(Employee t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateField(Employee employee) {

		return jdbcTemplate.update(UPDATE_EMPLOYEE, employee.getFirstName(),
				employee.getMiddleName(), employee.getLastName(),
				employee.getDob(), employee.getPrimaryContactNo(),
				employee.getSecondaryContactNo(), employee.getEmailId(),
				employee.getSkypeId(), employee.getPassword(),
				employee.getCode());
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
