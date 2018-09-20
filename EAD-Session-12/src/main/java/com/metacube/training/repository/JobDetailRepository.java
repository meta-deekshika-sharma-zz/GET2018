package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;

public interface JobDetailRepository<p> extends JpaRepository<JobDetails, Integer> {

	@Query("select e from JobDetails jd inner join jd.reportingMgr e inner join jd.projectId p where "
			+ "p.description = :description")
	public List<Employee> searchEmployeeByProject(@Param("description") String description); 
}
