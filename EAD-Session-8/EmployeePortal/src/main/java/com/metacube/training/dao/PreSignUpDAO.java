package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.metacube.training.model.PreSignUp;

/**
 * @author Deekshika Sharma
 * This class will have database access for pre sign up of employee
 */
public class PreSignUpDAO implements AdminDAO<PreSignUp> {

	@Override
	public int createField(PreSignUp preSignUp) {

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(PreSignUpQuery.INSERT_EMPLOYEE);
				PreparedStatement statement1 = conn
						.prepareStatement(PreSignUpQuery.INSERT_JOB_DETAIL);) {
			System.out.println("in upper");
			String[] result = preSignUp.getEmailId().split("@");
			System.out.println("in lower");

			statement.setString(1, result[0]);
			statement.setString(2, preSignUp.getFirstName());
			statement.setString(3, preSignUp.getMiddleName());
			statement.setString(4, preSignUp.getLastName());
			statement.setDate(5,
					new java.sql.Date(preSignUp.getDob().getTime()));
			statement.setString(6, preSignUp.getGender());
			statement.setString(7, preSignUp.getEmailId());
			statement.setString(8, "123456");

			statement1.setString(1, result[0]);
			statement1.setDate(2, new java.sql.Date(preSignUp.getDoj()
					.getTime()));
			statement1.setDouble(3, preSignUp.getTotalExp());
			statement1.setInt(4, preSignUp.getJobCode());
			statement1.setString(5, preSignUp.getReportinhMgr());
			statement1.setString(6, preSignUp.getTeamLead());
			statement1.setInt(7, preSignUp.getProjectId());

			statement.executeUpdate();
			return statement1.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
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
