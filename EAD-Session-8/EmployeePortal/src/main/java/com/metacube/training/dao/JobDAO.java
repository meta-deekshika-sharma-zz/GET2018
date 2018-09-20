package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.training.model.Job;

/**
 * @author Deekshika Sharma
 * This class will work for job database
 */
public class JobDAO implements AdminDAO<Job> {

	@Override
	public int createField(Job job) {
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(JobQuery.CREATE_JOB);) {
			statement.setString(1, job.getTitle());

			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateField(Job job) {
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(JobQuery.UPDATE_JOB);) {
			statement.setString(1, job.getTitle());
			statement.setInt(2, job.getCode());

			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteField(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Job> getField() {
		List<Job> jobList = new ArrayList<Job>();
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(JobQuery.GET_JOB_LIST);) {
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Job job = new Job();
				job.setCode(resultSet.getInt("job_code"));
				job.setTitle(resultSet.getString("job_title"));

				jobList.add(job);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobList;

	}

	@Override
	public Job getFieldById(String id) {

		int resultId = Integer.parseInt(id);
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(JobQuery.GET_JOB_BY_ID);) {
			statement.setInt(1, resultId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Job job = new Job();
				job.setCode(resultSet.getInt("code"));
				job.setTitle(resultSet.getString("title"));

				return job;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
