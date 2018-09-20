package com.metacube.training.dao;

public interface ProjectQuery {
	
	String UPDATE_PROJECT = "UPDATE Project SET description = :description, startDate = :start_date, endDate = :end_date WHERE id = :project_id";
	
	String GET_PROJECT_LIST = "from Project";
	
	String GET_PROJECT_BY_ID = "FROM Project WHERE id = :project_id";
}
