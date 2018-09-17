package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;

public interface JobDetailInterface {

	JobDetails getJobDetailsById(int id);
 	List<JobDetails> getAllJobDetails();
 	boolean deleteJobDetails(int id);
 	boolean updateJobDetails(JobDetails jobDetails);
 	boolean createJobDetails(JobDetails jobDetails);
	
	List<Employee> searchEmployeeByProject(String description);
}
