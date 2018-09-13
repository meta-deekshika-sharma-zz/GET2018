package com.metacube.training.dao;

public interface SkillQuery {
	
	String UPDATE_SKILL = "UPDATE Skill SET name = :skill_name WHERE id = :skill_id";
	
	String DELETE_SKILL = "DELETE FROM Skill WHERE id = :skill_id";
	
	String GET_SKILL_LIST = "FROM Skill";
	
	String GET_SKILL_BY_ID = "FROM Skill WHERE id = :skill_id";
}
