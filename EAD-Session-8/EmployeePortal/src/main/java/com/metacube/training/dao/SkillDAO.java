package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.training.model.Skill;

/**
 * @author Deekshika Sharma
 * This class will provide database access for skills
 */
public class SkillDAO implements AdminDAO<Skill> {

	@Override
	public int createField(Skill skill) {
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(SkillQuery.CREATE_SKILL);) {
			statement.setString(1, skill.getName());

			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateField(Skill skill) {
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(SkillQuery.UPDATE_SKILL);) {
			statement.setString(1, skill.getName());
			statement.setInt(2, skill.getId());

			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteField(String id) {
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(SkillQuery.DELETE_SKILL);) {
			int result = Integer.parseInt(id);
			statement.setInt(1, result);

			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Skill> getField() {
		List<Skill> skills = new ArrayList<Skill>();

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(SkillQuery.GET_SKILL_LIST);) {
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Skill skill = new Skill();
				skill.setId(resultSet.getInt("skill_id"));
				skill.setName(resultSet.getString("skill_name"));

				skills.add(skill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return skills;
	}

	@Override
	public Skill getFieldById(String skill_id) {
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(SkillQuery.GET_SKILL_BY_ID);) {
			int result = Integer.parseInt(skill_id);
			statement.setInt(1, result);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Skill skill = new Skill();
				skill.setId(resultSet.getInt("skill_id"));
				skill.setName(resultSet.getString("skill_name"));

				return skill;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getIdFromSkill(String skill) {
		
		String query = "SELECT Skill_id FROM SkillsMaster WHERE skill_name = ?";
		try(Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);
				)
		{
			System.out.println(skill);
			        statement.setString(1, skill);
			        ResultSet resultSet = statement.executeQuery();
			        
			        if (resultSet.next())
			        	return resultSet.getInt("skill_id");
	  } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return 0;
	}

	public int editSkill(int skill, String emp_code) {
		String query = "INSERT INTO EmployeeSkill (emp_code, skill_id) VALUES (?, ?)";
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setString(1, emp_code);
			statement.setInt(2, skill);

			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
