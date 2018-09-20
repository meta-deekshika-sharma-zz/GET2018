package com.metacube.training.dao;

public interface ProjectQuery {

    String CREATE_PROJECT = "INSERT INTO ProjectMaster (description, start_date, end_date, project_logo) VALUES (?, ?, ?, ?)";
	
	String UPDATE_PROJECT = "UPDATE ProjectMaster SET description = ?, start_date = ?, end_date = ?, project_logo = ? WHERE project_id = ?";
	
	String GET_PROJECT_LIST = "SELECT project_id, description, start_date, end_date, project_logo FROM ProjectMaster";
	
	String GET_PROJECT_BY_ID = "SELECT project_id, description, start_date, end_date, project_logo FROM ProjectMaster WHERE project_id = ?";
}
