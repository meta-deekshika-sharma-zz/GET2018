package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.EmployeeSkill;
import com.metacube.training.model.Skill;

/**
 * @author Deekshika Sharma
 * This class will provide database access for skills
 */
@Repository
@Transactional
public class SkillDAO implements AdminDAO<Skill> {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	EditEmployeeDAO employeeDAO;

	@Override
	public int createField(Skill skill) {
		try {
			return (Integer) sessionFactory.getCurrentSession().save(skill);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int updateField(Skill skill) {
		try {
			TypedQuery<Skill> query = sessionFactory.getCurrentSession()
					.createQuery(SkillQuery.UPDATE_SKILL);
			query.setParameter("skill_name", skill.getName());
			query.setParameter("skill_id", skill.getId());
			return query.executeUpdate();
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int deleteField(String id) {
		return 0;
	}

	@Override
	public List<Skill> getField() {
		TypedQuery<Skill> query = sessionFactory.getCurrentSession()
				.createQuery(SkillQuery.GET_SKILL_LIST);
		return query.getResultList();
	}

	@Override
	public Skill getFieldById(String skill_id) {
		int newId = Integer.parseInt(skill_id);
		try {
			TypedQuery<Skill> query = sessionFactory.getCurrentSession()
					.createQuery(SkillQuery.GET_SKILL_BY_ID);
			query.setParameter("skill_id", newId);
			return query.getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	private String GET_ID_FROM_SKILL = "FROM Skill WHERE name = :name";

	public int getIdFromSkill(String skill) {
		try {
			TypedQuery<Skill> query = sessionFactory.getCurrentSession()
					.createQuery(GET_ID_FROM_SKILL);
			query.setParameter("name", skill);
			Skill skills = query.getSingleResult();
			return skills.getId();
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
	}

	public int editSkill(int skill, String emp_code) {

		EmployeeSkill employeeSkill = new EmployeeSkill();
		employeeSkill.setEmployee(employeeDAO.getFieldById(emp_code));
		employeeSkill.setSkill(getFieldById(Integer.toString(skill)));
		try {
			return (Integer) sessionFactory.getCurrentSession().save(
					employeeSkill);
		} catch (Exception e) {
			return 0;
		}
	}
}
