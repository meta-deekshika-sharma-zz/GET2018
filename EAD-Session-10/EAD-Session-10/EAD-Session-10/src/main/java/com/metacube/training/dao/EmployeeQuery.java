package com.metacube.training.dao;

import org.springframework.stereotype.Repository;

/**
 * @author Deekshika Sharma 
 * This interfacce have queries for employee
 */
@Repository
public interface EmployeeQuery {

	String CREATE_EMPLOYEE = "INSERT INTO Employee (emp_code, first_name, middle_name, last_name, dob,"
			+ " gender, primary_contact_no, secondary_contact_no, email_id, skype_id, profile_picture, password)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	String UPDATE_EMPLOYEE = "UPDATE Employee SET first_name = ?, middle_name = ?, last_name = ?,"
			+ " dob = ?, primary_contact_no = ?, secondary_contact_no = ?, email_id = ?, skype_id = ? WHERE emp_code = ?";

	String DELETE_EMPLOYEE = "UPDATE Employee SET enabled = ? WHERE emp_code = ?";

	String GET_EMPLOYEE_LIST = "SELECT emp_code, first_name, middle_name, last_name, dob, gender,"
			+ " primary_contact_no, secondary_contact_no, email_id, skype_id, profile_picture, password FROM Employee WHERE enabled = ?";

	String GET_EMPLOYEE_BY_CODE = "SELECT emp_code, first_name, middle_name, last_name, dob, "
			+ "gender, primary_contact_no, secondary_contact_no, email_id, skype_id, password, profile_picture"
			+ " FROM Employee WHERE emp_code = ? AND enabled = ?";

}
