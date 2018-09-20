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
public class ProjectService implements ProjectServiceInterface{

	@Autowired
	ProjectRepository<Project> projectRepository;
	
	@Override
	public int addProject(Project project) {
		projectRepository.save(project);
		return 1;
	}

	@Override
	public int updateProject(Project project) {
        
		projectRepository.saveAndFlush(project);
		return 0;
	}

	@Override
	public int deleteProject(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Project> retreive() {
		return projectRepository.findAll();
	}

	@Override
	public Project getProjectById(int id) {
		return projectRepository.findOne(id);
	}
}
