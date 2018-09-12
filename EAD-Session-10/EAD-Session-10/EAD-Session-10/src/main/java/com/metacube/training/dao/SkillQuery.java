package com.metacube.training.dao;

public interface SkillQuery {

    String CREATE_SKILL = "INSERT INTO SkillsMaster (skill_name) VALUES (?)";
	
	String UPDATE_SKILL = "UPDATE SkillsMaster SET skill_name = ? WHERE skill_id = ?";
	
	String DELETE_SKILL = "DELETE FROM SkillsMaster WHERE skill_id = ?";
	
	String GET_SKILL_LIST = "SELECT skill_id, skill_name FROM SkillsMaster";
	
	String GET_SKILL_BY_ID = "SELECT skill_id, skill_name FROM SkillsMaster WHERE skill_id = ?";
}
