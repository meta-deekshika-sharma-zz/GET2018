package com.metacube.training.dao;

/**
 * @author Deekshika Sharma 
 * This interface will work for queries for job
 */
public interface JobQuery {

	String UPDATE_JOB = "UPDATE Job SET title = :job_title WHERE code = :job_code";

	String GET_JOB_LIST = "FROM Job";

	String GET_JOB_BY_ID = "FROM JobTitleMaster WHERE code = :job_code";
}
