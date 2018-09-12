package com.metacube.training.dao;

/**
 * @author Deekshika Sharma 
 * This interface will work for queries for job
 */
public interface JobQuery {

	String CREATE_JOB = "INSERT INTO JobTitleMaster (job_title) VALUES (?)";

	String UPDATE_JOB = "UPDATE JobTitleMaster SET job_title = ? WHERE job_code = ?";

	String GET_JOB_LIST = "SELECT job_code, job_title FROM JobTitleMaster";

	String GET_JOB_BY_ID = "SELECT job_code, job_title FROM JobTitleMaster WHERE job_code = ?";
}
