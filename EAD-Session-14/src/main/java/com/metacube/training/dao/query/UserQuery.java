package com.metacube.training.dao.query;

public interface UserQuery {

	String GET_ALL_USERS = "select u.username, u.password, r.role from "
			+ "User u left join UserRole r on r.username = u.username";
}
