package com.metacube.training.dao;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.PreSignUp;

/**
 * @author Deekshika Sharma
 * This class will have database access for pre sign up of employee
 */
@Repository
@Transactional
public class PreSignUpDAO implements AdminDAO<PreSignUp> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int createField(PreSignUp preSignUp) {
		
		String[] result = preSignUp.getEmailId().split("@");
		System.out.println(result[0]);
		preSignUp.setCode(result[0]);
		preSignUp.setPassword("123456");
		try {
			
			return (Integer) sessionFactory.getCurrentSession().save(preSignUp);
		} catch(Exception e)
		{
			return 0;
		}
	}
	
	@Override
	public int updateField(PreSignUp t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteField(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PreSignUp> getField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreSignUp getFieldById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
