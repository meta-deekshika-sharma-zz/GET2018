package com.metacube.training.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

/**
 * @author Deekshika Sharma 
 * This interfacce have queries for employee
 */
@Repository
@Transactional
public interface EmployeeQuery {

	String UPDATE_EMPLOYEE = "UPDATE Employee SET firstName = :first_name, middleName = :middle_name, lastName = :last_name,"
			+ " dob = :dob, primaryContactNo = :primary_contact_no, secondaryContactNo = :secondary_contact_no, emailId = :email_id, skypeId = :skype_id, password = :password WHERE emp_code = :emp_code";

	String DELETE_EMPLOYEE = "UPDATE Employee SET enabled = :enabled WHERE emp_code = :emp_code";

	String GET_EMPLOYEE_LIST = "FROM Employee";

	String GET_EMPLOYEE_BY_CODE = "FROM Employee WHERE emp_code = :emp_code";
	
	String EMAIL_VALIDATION = "FROM Employee WHERE emailId = :email_id";
	
	String GET_EMPLOYEE_VALIDATION = "FROM Employee WHERE emp_code = :emp_code AND password = :password";
	
}
