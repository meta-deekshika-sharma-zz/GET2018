package com.metacube.training.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mapper.EmployeeMapper;
import com.metacube.training.model.Employee;

/**
 * @author Deekshika Sharma 
 * This class will provide dabase access for employees
 */
@Repository
public class EmployeeDAO implements AdminDAO<Employee> {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDAO(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public int createField(Employee employee) {
		return 0;
	}

	@Override
	public int updateField(Employee employee) {
		System.out.println(jdbcTemplate);
		return jdbcTemplate.update(EmployeeQuery.UPDATE_EMPLOYEE,
				employee.getFirstName(), employee.getMiddleName(),
				employee.getLastName(), employee.getDob(),
				employee.getPrimaryContactNo(),
				employee.getSecondaryContactNo(), employee.getEmailId(),
				employee.getSkypeId(), employee.getCode());
	}

	@Override
	public int deleteField(String id) {
		return jdbcTemplate.update(EmployeeQuery.DELETE_EMPLOYEE,
				new Object[] {true, id});
	}

	@Override
	public List<Employee> getField() {

		return jdbcTemplate.query(EmployeeQuery.GET_EMPLOYEE_LIST,
				new Object[] { true }, new EmployeeMapper());
	}

	@Override
	public Employee getFieldById(String id) {
		return jdbcTemplate.queryForObject(EmployeeQuery.GET_EMPLOYEE_BY_CODE,
				new Object[] { id, true }, new EmployeeMapper());
	}

	public static boolean isValidAdminLogin(String username, String password) {
		if ("admin".equals(username) && "admin".equals(password))
			return true;
		return false;
	}

	private String EMAIL_VALIDATION = "SELECT * from Employee WHERE email_id = ?";

	public Employee isEmailAvailable(String email) {
		return jdbcTemplate.queryForObject(EMAIL_VALIDATION,
				new Object[] { email }, new EmployeeMapper());
	}

	private String GET_CODE_BY_EMAIL = "SELECT emp_code from Employee WHERE email_id = ?";

	public String getCodeByEmail(String email) {

		Employee employee = jdbcTemplate.queryForObject(GET_CODE_BY_EMAIL,
				new Object[] { email }, new EmployeeMapper());
		return employee.getCode();
	}

	private String GET_EMPLOYEE_VALIDATION = "SELECT * from Employee WHERE emp_code = ? AND password = ?";

	public Employee isValidEmployeeLogin(String username, String password) {
		return jdbcTemplate.queryForObject(GET_EMPLOYEE_VALIDATION,
				new Object[] { username, password }, new EmployeeMapper());
	}
	
	private String CHANGE_PASSWORd = "Update Employee SET password = ? WHERE email_id = ?";
	public int changePassword(String email, String password)
	{
		return jdbcTemplate.update(CHANGE_PASSWORd, password, email);
	}
}
