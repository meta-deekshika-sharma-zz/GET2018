package com.metacube.training.dao;

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
import com.metacube.training.model.Job;

/**
 * @author Deekshika Sharma
 * This class will have database access for search implementation
 */
@Repository
public class SearchDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SearchDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Employee> searchByName(String employeeName) {
		return jdbcTemplate.query(SearchQuery.SEARCH_BY_NAME, new Object[] {employeeName}, new EmployeeMapper());
	}

	public List<Employee> searchByProject(int project_id) {
		
		return jdbcTemplate.query(SearchQuery.SEARCH_BY_PROJECT, new Object[] {project_id}, new EmployeeMapper());
	}

	public List<Employee> searchBySkill(int skill_id) {
		return jdbcTemplate.query(SearchQuery.SEARCH_BY_SKILL, new Object[] {skill_id}, new EmployeeMapper());
	}

	public List<Employee> searchByTotalExperience(Double total_exp) {
		return jdbcTemplate.query(SearchQuery.SEARCH_BY_TOTAL_EXP, new Object[] {total_exp}, new EmployeeMapper());
	}
}
