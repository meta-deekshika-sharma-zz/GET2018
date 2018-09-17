package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Job;

public interface JobServiceInterface {

	Job getJobTitleById(int id);
 	List<Job> getAllJobTitles();
 	boolean deleteJobTitle(int id);
 	boolean updateJobTitle(Job job);
 	boolean createJobTitle(Job job);
}
