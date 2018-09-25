package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.query.UserQuery;
import com.metacube.training.mapper.UserMapper;
import com.metacube.training.model.User;

@Repository
public class UserDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public UserDAO(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<User> getAllUsers() {
		return jdbcTemplate.query(UserQuery.GET_ALL_USERS, new UserMapper());
	}
}
