package com.Facade;

import com.DAO.JDBCQuery;
import com.Model.UserDAO;

public class UserFacade {

	private static UserFacade user = new UserFacade();
	
	public static UserFacade getInstance()
	{
		return user;
	}
	
	public boolean validateEmail(UserDAO user)
	{
		if(!JDBCQuery.validateEmail(user.getEmail()))
		{
			if(JDBCQuery.addUser(user) > 0)
			{
				return true;
			}
		}
		return false;
	}
}
