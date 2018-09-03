package com.Facade;

import com.DAO.JDBCQuery;
import com.Model.UserDAO;

public class UserFacade {

	private static UserFacade user = new UserFacade();

	public static UserFacade getInstance() {
		return user;
	}

	public boolean validateEmail(UserDAO user) {
		if (!JDBCQuery.validateEmail(user.getEmail())) {
			if (JDBCQuery.addUser(user) > 0) {
				System.out.println(JDBCQuery.getUser(user.getEmail(), user.getPassword()));
				return true;
			}
		}
		return false;
	}
	
	 public UserDAO getDetails(String email, String password)
	    {
	        
	        return JDBCQuery.getUser(email, password);
	    }
}
