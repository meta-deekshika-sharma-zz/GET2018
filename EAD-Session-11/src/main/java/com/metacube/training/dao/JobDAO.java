package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Job;

/**
 * @author Deekshika Sharma 
 * This class will work for job database
 */
@Repository
@Transactional
public class JobDAO implements AdminDAO<Job> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int createField(Job job) {
		 try
	        {
			 return (Integer) sessionFactory.getCurrentSession().save(job);
	        } catch (Exception e)
	        {
	            return 0;
	        }
	}

	@Override
	public int updateField(Job job) {
		  try
	        {
	            TypedQuery<Job> query = sessionFactory.getCurrentSession()
	                    .createQuery(JobQuery.UPDATE_JOB);
	            query.setParameter("job_title", job.getTitle());
	            query.setParameter("job_code", job.getCode());
	            return query.executeUpdate();
	        } catch (Exception e)
	        {
	            return 0;
	        }
	}

	@Override
	public int deleteField(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Job> getField() {
		TypedQuery<Job> query = sessionFactory.getCurrentSession()
                .createQuery(JobQuery.GET_JOB_LIST);
        return query.getResultList();
	}

	public Job getJobById(Integer id) {

		try
        {
            TypedQuery<Job> query = sessionFactory.getCurrentSession()
                    .createQuery(JobQuery.GET_JOB_BY_ID);
            query.setParameter("job_code", id);
            return query.getSingleResult();
        } catch (EmptyResultDataAccessException e)
        {
            return null;
        }
	}

	@Override
	public Job getFieldById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
