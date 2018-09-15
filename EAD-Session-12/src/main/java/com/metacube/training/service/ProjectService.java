package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Project;
import com.metacube.training.repository.ProjectRepository;

/**
 * @author Deekshika Sharma
 * This class will have implementation for Project service 
 */
@Service
public class ProjectService implements AdminService<Project>{

	@Autowired
	ProjectRepository<Project> projectRepository;
	
	@Override
	public int addField(Project project) {
		projectRepository.save(project);
		return 1;
	}

	@Override
	public int updateField(Project project) {
        
		projectRepository.saveAndFlush(project);
		return 0;
	}

	@Override
	public int deleteField(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Project> retreive() {
		return projectRepository.findAll();
	}

	@Override
	public Project getFieldById(String id) {
		Integer idd = Integer.parseInt(id);
		return projectRepository.findOne(idd);
	}
}
