package com.metacube.training.dao;

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
 * This class will have database access for search implementation
 */
@Repository
@Transactional
public class SearchDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Employee> searchByName(String employeeCode) {
		try
        {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                    .createQuery(SearchQuery.SEARCH_BY_NAME);
            query.setParameter("emp_code", employeeCode);
            return query.getResultList();
        } catch (EmptyResultDataAccessException e)
        {
            return null;
        }
	}

	public List<Employee> searchByProject(int project_id) {
		
		try
        {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                    .createQuery(SearchQuery.SEARCH_BY_PROJECT);
            query.setParameter("id", project_id);
            return query.getResultList();
        } catch (EmptyResultDataAccessException e)
        {
            return null;
        }
	}

	public List<Employee> searchBySkill(int skill_id) {
		try
        {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                    .createQuery(SearchQuery.SEARCH_BY_SKILL);
            query.setParameter("id", skill_id);
            return query.getResultList();
        } catch (EmptyResultDataAccessException e)
        {
            return null;
        }
	}

	public List<Employee> searchByTotalExperience(Double total_exp) {
		try
        {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                    .createQuery(SearchQuery.SEARCH_BY_TOTAL_EXP);
            query.setParameter("total_exp", total_exp);
            return query.getResultList();
        } catch (EmptyResultDataAccessException e)
        {
            return null;
        }
	}
}
