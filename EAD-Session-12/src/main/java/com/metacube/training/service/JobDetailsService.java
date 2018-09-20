package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;
import com.metacube.training.repository.JobDetailRepository;

@Service
public class JobDetailsService implements JobDetailInterface{

	@Autowired
	JobDetailRepository<JobDetails> jobDetailsRepository;
	
	@Override
	public JobDetails getJobDetailsById(int id) {
		return jobDetailsRepository.findOne(id);
	}

	@Override
	public List<JobDetails> getAllJobDetails() {
		return jobDetailsRepository.findAll();
	}

	@Override
	public boolean deleteJobDetails(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateJobDetails(JobDetails jobDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createJobDetails(JobDetails jobDetails) {
		jobDetailsRepository.save(jobDetails);
		return false;
	}

	@Override
	public List<Employee> searchEmployeeByProject(String description) {
		return jobDetailsRepository.searchEmployeeByProject(description);
	}

}
