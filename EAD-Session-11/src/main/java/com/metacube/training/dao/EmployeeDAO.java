package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;

/**
 * @author Deekshika Sharma 
 * This class will work for editing employee database
 */
@Repository
@Transactional
public class EmployeeDAO implements EmployeeProfileDAO<Employee> {

	@Autowired
	private SessionFactory sessionFactory;

	private final String UPDATE_EMPLOYEE = "UPDATE Employee SET first_name = :firstName, middle_name = :middleName, last_name = :lastName,"
			+ " dob = :dob, primary_contact_no = :primaryContactNo, secondary_contact_no = :secondaryContactNo, email_id = :emailId, skype_id = :skypeId, password = :password WHERE emp_code = :empCode";

	@Override
	public int createField(Employee t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateField(Employee employee) {

		try
        {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                    .createQuery(UPDATE_EMPLOYEE);
            query.setParameter("firstName", employee.getFirstName());
            query.setParameter("middleName", employee.getMiddleName());
            query.setParameter("lastName", employee.getLastName());
            query.setParameter("dob", employee.getDob());
            query.setParameter("primaryContactNo", employee.getPrimaryContactNo());
            query.setParameter("secondaryContactNo", employee.getSecondaryContactNo());
            query.setParameter("emailId", employee.getEmailId());
            query.setParameter("skypeId", employee.getSkypeId());
            query.setParameter("password", employee.getPassword());
            query.setParameter("empCode", employee.getCode());
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
	public List<Employee> getField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getFieldById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
