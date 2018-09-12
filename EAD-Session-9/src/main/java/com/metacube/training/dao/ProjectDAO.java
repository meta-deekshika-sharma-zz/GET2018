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

import com.metacube.training.mapper.ProjectMapper;
import com.metacube.training.model.Project;

/**
 * @author Deekshika Sharma
 * This class have database access for project implementation
 */
@Repository
public class ProjectDAO implements AdminDAO<Project> {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ProjectDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public int createField(Project project) {
		System.out.println(project.getDescription());
		if(project == null)
			return 0;
		return jdbcTemplate.update(ProjectQuery.CREATE_PROJECT, project.getDescription(), project.getStartDate(), project.getEndDate(), project.getLogo());
	}

	@Override
	public int updateField(Project project) {
		return jdbcTemplate.update(ProjectQuery.UPDATE_PROJECT, project.getDescription(), project.getStartDate(), project.getEndDate(), project.getLogo());
	}

	@Override
	public int deleteField(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Project> getField() {
		return jdbcTemplate.query(ProjectQuery.GET_PROJECT_LIST, new ProjectMapper());
	}

	@Override
	public Project getFieldById(String project_id) {
		int newId = Integer.parseInt(project_id);
		return jdbcTemplate.queryForObject(ProjectQuery.GET_PROJECT_BY_ID, new Object[] {newId}, new ProjectMapper());
	}

}
