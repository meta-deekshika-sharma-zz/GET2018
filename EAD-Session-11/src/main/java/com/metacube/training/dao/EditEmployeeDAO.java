package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.mapper.EmployeeMapper;
import com.metacube.training.model.Employee;

/**
 * @author Deekshika Sharma 
 * This class will provide dabase access for employees
 */

@Repository
@Transactional
public class EditEmployeeDAO implements AdminDAO<Employee> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int createField(Employee employee) {
		return 0;
	}

	@Override
	public int updateField(Employee employee) {
		System.out.println(employee.getFirstName());
		 try
	        {
	            TypedQuery<Employee> query = sessionFactory.getCurrentSession()
	                    .createQuery(EmployeeQuery.UPDATE_EMPLOYEE);
	            
	            query.setParameter("first_name", employee.getFirstName());
	            query.setParameter("middle_name", employee.getMiddleName());
	            query.setParameter("last_name", employee.getLastName());
	            query.setParameter("dob", employee.getDob());
	 //           query.setParameter("gender", employee.getGender());
	            query.setParameter("primary_contact_no", employee.getPrimaryContactNo());
	            query.setParameter("secondary_contact_no", employee.getSecondaryContactNo());
	            query.setParameter("email_id", employee.getEmailId());
	            query.setParameter("skype_id", employee.getSkypeId());
	            query.setParameter("password", employee.getPassword());
	            query.setParameter("emp_code", employee.getCode());
	            return query.executeUpdate();
	        } catch (Exception e)
	        {
	            return 0;
	        }
	}

	@Override
	public int deleteField(String id) {
		try
        {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                    .createQuery(EmployeeQuery.DELETE_EMPLOYEE);
            query.setParameter("enabled", false);
            query.setParameter("emp_code", id);
            return query.executeUpdate();
        } catch (Exception e)
        {
            return 0;
        }
	}

	@Override
	public List<Employee> getField() {

		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                .createQuery(EmployeeQuery.GET_EMPLOYEE_LIST);
        return query.getResultList();
	}

	@Override
	public Employee getFieldById(String id) {
		try
        {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                    .createQuery(EmployeeQuery.GET_EMPLOYEE_BY_CODE);
            query.setParameter("emp_code", id);
            return query.getSingleResult();
        } catch (EmptyResultDataAccessException e)
        {
            return null;
        }
	}

	public static boolean isValidAdminLogin(String username, String password) {
		if ("admin".equals(username) && "admin".equals(password))
			return true;
		return false;
	}

	
	public Employee isEmailAvailable(String email) {
		try
        {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                    .createQuery(EmployeeQuery.EMAIL_VALIDATION);
            query.setParameter("email_id", email);
            return query.getSingleResult();
        } catch (EmptyResultDataAccessException e)
        {
            return null;
        }
	}



	public Employee isValidEmployeeLogin(String username, String password) {
		try
        {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                    .createQuery(EmployeeQuery.GET_EMPLOYEE_VALIDATION);
            query.setParameter("emp_code", username);
            query.setParameter("password", password);
            return query.getSingleResult();
        } catch (EmptyResultDataAccessException e)
        {
            return null;
        }	
	}
}
