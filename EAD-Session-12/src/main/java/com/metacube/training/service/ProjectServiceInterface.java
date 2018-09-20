package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Project;

public interface ProjectServiceInterface {

	public int addProject(Project project);

	public int updateProject(Project project);

	public int deleteProject(int id);

	public List<Project> retreive();

	public Project getProjectById(int id);
}
