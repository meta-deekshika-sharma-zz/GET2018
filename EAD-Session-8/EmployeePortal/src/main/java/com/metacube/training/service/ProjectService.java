package com.metacube.training.service;

import java.util.List;

import com.metacube.training.dao.ProjectDAO;
import com.metacube.training.model.Project;

/**
 * @author Deekshika Sharma
 * This class will have implementation for Project service 
 */
public class ProjectService implements AdminService<Project>{

	ProjectDAO projectDAO = new ProjectDAO();
	@Override
	public int addField(Project project) {
		System.out.println(project);
		return projectDAO.createField(project);
	}

	@Override
	public int updateField(Project project) {
        
		int id = project.getId();
		
		String project_id = Integer.toString(id);
		if(getFieldById(project_id) != null)
		{
			projectDAO.updateField(project);
		}
		return 0;
	}

	@Override
	public int deleteField(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Project> retreive() {
		return projectDAO.getField();
	}

	@Override
	public Project getFieldById(String id) {
		return projectDAO.getFieldById(id);
	}
}
