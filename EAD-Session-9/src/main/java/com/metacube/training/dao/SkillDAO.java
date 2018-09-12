package com.metacube.training.dao;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mapper.SkillMapper;
import com.metacube.training.model.Skill;

/**
 * @author Deekshika Sharma
 * This class will provide database access for skills
 */
@Repository
public class SkillDAO implements AdminDAO<Skill> {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SkillDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public int createField(Skill skill) {
		return jdbcTemplate.update(SkillQuery.CREATE_SKILL, skill.getName());
	}

	@Override
	public int updateField(Skill skill) {
		return jdbcTemplate.update(SkillQuery.UPDATE_SKILL, skill.getName(), skill.getId());
	}

	@Override
	public int deleteField(String id) {
		int newId = Integer.parseInt(id);
		return jdbcTemplate.update(SkillQuery.DELETE_SKILL, newId);
	}

	@Override
	public List<Skill> getField() {
		return jdbcTemplate.query(SkillQuery.GET_SKILL_LIST, new SkillMapper());
	}

	@Override
	public Skill getFieldById(String skill_id) {
		int newId = Integer.parseInt(skill_id);
		return jdbcTemplate.queryForObject(SkillQuery.GET_SKILL_BY_ID, new Object[] {newId}, new SkillMapper());
	}

	private String GET_ID_FROM_SKILL = "SELECT * FROM SkillsMaster WHERE skill_name = ?";
	public int getIdFromSkill(String skill) {
		System.out.println(skill);
		Skill skills = jdbcTemplate.queryForObject(GET_ID_FROM_SKILL, new Object[] {skill}, new SkillMapper());
		int id =  skills.getId();
		System.out.println(id);
		return id;
	}

	private String EDIT_SKILL = "INSERT INTO EmployeeSkill (emp_code, skill_id) VALUES (?, ?)";
	public int editSkill(int skill, String emp_code) {
		return jdbcTemplate.update(EDIT_SKILL, emp_code, skill);
	}
}
