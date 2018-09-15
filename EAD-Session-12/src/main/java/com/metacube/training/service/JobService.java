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
public class JobService implements AdminService<Job> {

	@Autowired
	private JobTitleRepository<Job> jobTitleRepository;

	@Override
	public int addField(Job job) {

		jobTitleRepository.save(job);
		return 1;
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
		return jobTitleRepository.findAll();
	}

	@Override
	public Job getFieldById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
