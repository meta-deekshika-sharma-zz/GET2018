package com.metacube.training.service;

import java.util.List;

import com.metacube.training.dao.SkillDAO;
import com.metacube.training.model.Skill;

/**
 * @author Deekshika Sharma
 * this class will work as service for skills
 */
public class SkillService implements AdminService<Skill> {

	SkillDAO skillDAO = new SkillDAO();

	@Override
	public int addField(Skill skill) {
		return skillDAO.createField(skill);
	}

	@Override
	public int updateField(Skill skill) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteField(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Skill> retreive() {
		return skillDAO.getField();
	}

	@Override
	public Skill getFieldById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertSkills(String[] skills, String emp_code) {
		System.out.println("length" + skills.length);
		
		for (String skill: skills) {
			
			System.out.println("name" + skill);
			int id = skillDAO.getIdFromSkill(skill);
			System.out.println("1" + id);
			if (id > 0)
				skillDAO.editSkill(id, emp_code);
		}
		return 0;
	}
}
