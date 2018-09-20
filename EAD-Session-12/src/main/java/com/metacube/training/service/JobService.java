package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.metacube.training.model.Job;
import com.metacube.training.repository.JobTitleRepository;

/**
 * @author Deekshika Sharma
 * This class will have implementation for job
 */
@Service
public class JobService implements JobServiceInterface {

	@Autowired
	private JobTitleRepository<Job> jobTitleRepository;

	public Job getJobTitleById(int id) {
		return jobTitleRepository.findOne(id);
	}

	@Override
	public List<Job> getAllJobTitles() {
		return jobTitleRepository.findAll();
	}

	@Override
	public boolean deleteJobTitle(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateJobTitle(Job job) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createJobTitle(Job job) {
		jobTitleRepository.save(job);
		return true;
	}
}
