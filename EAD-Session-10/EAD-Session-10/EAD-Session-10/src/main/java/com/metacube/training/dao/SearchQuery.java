package com.metacube.training.dao;

public interface SearchQuery {

	String SEARCH_BY_NAME = "SELECT emp_code, first_name, middle_name, last_name, dob, email_id, skype_id, primary_contact_no, secondary_contact_no, password FROM Employee"
			+ " WHERE emp_code = ?";
	
	String SEARCH_BY_PROJECT = "SELECT e.emp_code, e.first_name, e.middle_name, e.last_name, e.dob, e.email_id, e.skype_id, e.primary_contact_no, e.secondary_contact_no, e.password, "
			+ "j.curr_project_id FROM Employee AS e INNER JOIN JobDetails AS j ON e.emp_code = j.emp_code WHERE j.curr_project_id = ?";
	
	String SEARCH_BY_SKILL = "SELECT e.emp_code, e.first_name, e.middle_name, e.last_name, e.dob, e.email_id, e.skype_id, e.primary_contact_no, e.secondary_contact_no, e.password, "
			+ "s.skill_id FROM Employee e INNER JOIN EmployeeSkill s ON e.emp_code = s.emp_code WHERE s.skill_id = ?";
	
	String SEARCH_BY_TOTAL_EXP = "SELECT e.emp_code, e.first_name, e.middle_name, e.last_name, e.dob, e.email_id, e.skype_id, e.primary_contact_no, e.secondary_contact_no, e.password, "
			+ "j.curr_project_id FROM Employee e INNER JOIN JobDetails j ON e.emp_code = j.emp_code WHERE j.total_exp = ?";
}
