package com.metacube.training.service;

import java.util.List;

import com.metacube.training.dao.JobDAO;
import com.metacube.training.model.Job;

/**
 * @author Deekshika Sharma
 * This class will have implementation for job
 */
public class JobService implements AdminService<Job> {

	JobDAO jobDAO = new JobDAO();

	@Override
	public int addField(Job job) {

		return jobDAO.createField(job);
	}

	@Override
	public int updateField(Job job) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteField(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Job> retreive() {
		return jobDAO.getField();
	}

	@Override
	public Job getFieldById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
