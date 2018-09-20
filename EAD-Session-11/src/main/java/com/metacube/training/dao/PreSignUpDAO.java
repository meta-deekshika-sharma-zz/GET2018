package com.metacube.training.dao;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.PreSignUp;

/**
 * @author Deekshika Sharma
 * This class will have database access for pre sign up of employee
 */
@Repository
@Transactional
public class PreSignUpDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public int createField(Employee employee, JobDetails jobDetails) {

		try {
			
			sessionFactory.getCurrentSession().save(employee);
			sessionFactory.getCurrentSession().save(jobDetails);
			return 1;
		} catch(Exception e)
		{
			return 0;
		}
	}

}
