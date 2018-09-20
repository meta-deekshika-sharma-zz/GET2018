package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mapper.JobMapper;
import com.metacube.training.model.Job;

/**
 * @author Deekshika Sharma 
 * This class will work for job database
 */
@Repository
public class JobDAO implements AdminDAO<Job> {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JobDAO(javax.sql.DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public int createField(Job job) {

		return jdbcTemplate.update(JobQuery.CREATE_JOB, job.getTitle());
	}

	@Override
	public int updateField(Job job) {
		return jdbcTemplate.update(JobQuery.UPDATE_JOB, job.getTitle());
	}

	@Override
	public int deleteField(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Job> getField() {
		return jdbcTemplate.query(JobQuery.GET_JOB_LIST, new JobMapper());
	}

	@Override
	public Job getFieldById(String id) {

		int resultId = Integer.parseInt(id);
		return jdbcTemplate.queryForObject(JobQuery.GET_JOB_BY_ID,
				new Object[] { id }, new JobMapper());
	}
}
