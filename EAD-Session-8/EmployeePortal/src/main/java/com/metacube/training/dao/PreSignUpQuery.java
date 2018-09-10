package com.metacube.training.dao;

public interface PreSignUpQuery {

	String INSERT_EMPLOYEE = "INSERT INTO Employee (emp_code, first_name, middle_name, last_name, dob,"
			+ " gender, email_id, password)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	String UPDATE_EMPLOYEE = "UPDATE Employee SET first_name = ?, middle_name = ?, last_name = ?,"
			+ " dob = ?, gender = ?, email_id = ?, password = ? WHERE emp_code = ?";

	String DELETE_EMPLOYEE = "UPDATE Employee SET enabled = ? WHERE emp_code = ?";

	String GET_EMPLOYEE_LIST = "SELECT emp_code, first_name, middle_name, last_name, dob, gender,"
			+ " primary_contact_no, secondary_contact_no, email_id, skype_id, profile_picture, password FROM Employee";

	String GET_EMPLOYEE_BY_CODE = "SELECT emp_code, first_name, middle_name, last_name, dob, "
			+ "gender, email_id"
			+ " FROM Employee WHERE emp_code = ?";
	
	String INSERT_JOB_DETAIL = "INSERT INTO JobDetails (emp_code, date_of_joining, total_exp,"
			+ " job_code, reporting_mgr, team_lead, curr_project_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
}
