package com.metacube.training.dao;

public interface SearchQuery {

	String SEARCH_BY_NAME = "FROM Employee WHERE emp_code = :emp_code";
	
	String SEARCH_BY_PROJECT = "SELECT e FROM JobDetails j INNER JOIN j.employeeCode e INNER JOIN j.projectId p WHERE p.id = :id";
	
	String SEARCH_BY_SKILL = "SELECT e FROM EmployeeSkill es INNER JOIN es.employee e INNER JOIN es.skill s WHERE s.id = :id";
	
	String SEARCH_BY_TOTAL_EXP = "SELECT e FROM JobDetails j INNER JOIN j.employeeCode e WHERE j.totalExperience = :total_exp";
}
