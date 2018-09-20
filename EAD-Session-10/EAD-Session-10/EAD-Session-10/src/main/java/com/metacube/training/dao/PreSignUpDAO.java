package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.PreSignUp;

/**
 * @author Deekshika Sharma
 * This class will have database access for pre sign up of employee
 */
@Repository
public class PreSignUpDAO implements AdminDAO<PreSignUp> {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public PreSignUpDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int createField(PreSignUp preSignUp) {
		
		String[] result = preSignUp.getEmailId().split("@");
		jdbcTemplate.update(PreSignUpQuery.INSERT_EMPLOYEE, result[0], preSignUp.getFirstName(), preSignUp.getMiddleName(),
				preSignUp.getLastName(), new java.sql.Date(preSignUp.getDob().getTime()), preSignUp.getGender(), preSignUp.getEmailId(),"123456");
				
        return jdbcTemplate.update(PreSignUpQuery.INSERT_JOB_DETAIL, result[0], new java.sql.Date(preSignUp.getDoj().getTime()), preSignUp.getTotalExp(),
        		preSignUp.getJobCode(), preSignUp.getReportinhMgr(), preSignUp.getTeamLead(), preSignUp.getProjectId());
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
