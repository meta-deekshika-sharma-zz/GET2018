package com.metacube.training.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Job;
import com.metacube.training.model.Project;

/**
 * @author Deekshika Sharma
 * This class have database access for project implementation
 */
@Repository
@Transactional
public class ProjectDAO implements AdminDAO<Project> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int createField(Project project) {
		    try
	        {
			 return (Integer) sessionFactory.getCurrentSession().save(project);
	        } catch (Exception e)
	        {
	            return 0;
	        }
	}

	@Override
	public int updateField(Project project) {
		    try
	        {
	            TypedQuery<Job> query = sessionFactory.getCurrentSession()
	                    .createQuery(ProjectQuery.UPDATE_PROJECT);
	            query.setParameter("description", project.getDescription());
	            query.setParameter("start_date", project.getStartDate());
	            query.setParameter("end_date", project.getEndDate());
	            query.setParameter("project_id", project.getId());
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
	public List<Project> getField() {
		TypedQuery<Project> query = sessionFactory.getCurrentSession()
                .createQuery(ProjectQuery.GET_PROJECT_LIST);
        return query.getResultList();
	}

	public Project getProjectById(Integer project_id) {
		try
        {
            TypedQuery<Project> query = sessionFactory.getCurrentSession()
                    .createQuery(ProjectQuery.GET_PROJECT_BY_ID);
            query.setParameter("project_id", project_id);
            return query.getSingleResult();
        } catch (EmptyResultDataAccessException e)
        {
            return null;
        }
	}

	@Override
	public Project getFieldById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
