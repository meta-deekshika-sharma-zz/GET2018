package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.ProjectDAO;
import com.metacube.training.model.Project;

/**
 * @author Deekshika Sharma
 * This class will have implementation for Project service 
 */
@Service
public class ProjectService implements AdminService<Project>{

	@Autowired
	ProjectDAO projectDAO;
	
	@Override
	public int addField(Project project) {
		
		System.out.println(project);
		if(project == null)
			return 0;
        if(project.getStartDate().after(project.getEndDate()))
        	return 0;
        System.out.println("pp");
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
