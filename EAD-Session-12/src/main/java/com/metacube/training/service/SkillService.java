package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Skill;
import com.metacube.training.repository.SkillsRepository;

/**
 * @author Deekshika Sharma
 * this class will work as service for skills
 */
@Service
public class SkillService implements AdminService<Skill> {

	@Autowired
	SkillsRepository<Skill> skillRepository;

	@Override
	public int addField(Skill skill) {
		skillRepository.save(skill);
		return 1;
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
		return skillRepository.findAll();
	}

	@Override
	public Skill getFieldById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

//	public int insertSkills(String[] skills, String emp_code) {
//		System.out.println("length" + skills.length);
//		
//		for (String skill: skills) {
//			
//			System.out.println("name" + skill);
//			int id = skillDAO.getIdFromSkill(skill);
//			System.out.println("1" + id);
//			if (id > 0)
//				skillDAO.editSkill(id, emp_code);
//		}
//		return 0;
//	}
}
