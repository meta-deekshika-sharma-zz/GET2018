package com.metacube.training.service;

import java.util.List;

import com.metacube.training.dao.SearchDAO;
import com.metacube.training.model.Employee;

/**
 * @author Deekshika Sharma
 * This class will have implementation for Search service 
 */
public class SearchService {

	SearchDAO searchDAO = new SearchDAO();

	public List<Employee> searchByName(String employeeName) {
		System.out.println(employeeName);
		return searchDAO.searchByName(employeeName);
	}

	public List<Employee> searchByProject(int project_id) {
		return searchDAO.searchByProject(project_id);
	}

	public List<Employee> searchBySkill(int skill_id) {
		return searchDAO.searchBySkill(skill_id);
	}

	public List<Employee> searchByTotalExperience(Double total_exp) {
		return searchDAO.searchByTotalExperience(total_exp);
	}
}
