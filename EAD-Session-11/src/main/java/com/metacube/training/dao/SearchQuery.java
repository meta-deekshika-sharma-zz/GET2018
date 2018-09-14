package com.metacube.training.dao;

public interface SearchQuery {

	String SEARCH_BY_NAME = "FROM Employee WHERE emp_code = :emp_code";
	
	String SEARCH_BY_PROJECT = "FROM SearchResult WHERE curr_project_id = :id";
	
	String SEARCH_BY_SKILL = "FROM EmployeeSkill WHERE skill_id = :id";
	
	String SEARCH_BY_TOTAL_EXP = "FROM SearchResult WHERE total_exp = :total_exp";
}
