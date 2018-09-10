package com.metacube.training.service;

import java.util.List;

import com.metacube.training.dao.PreSignUpDAO;
import com.metacube.training.model.PreSignUp;

/**
 * @author Deekshika Sharma
 * This class will have implementation for Pre sign up service 
 */
public class PreSignUpService implements AdminService<PreSignUp> {

	PreSignUpDAO preSignUpDAO = new PreSignUpDAO();

	@Override
	public int addField(PreSignUp preSignUp) {
		System.out.println(preSignUp);
		return preSignUpDAO.createField(preSignUp);
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
	public List<PreSignUp> retreive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreSignUp getFieldById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
