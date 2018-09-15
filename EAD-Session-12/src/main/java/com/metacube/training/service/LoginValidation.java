package com.metacube.training.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.Employee;

public interface LoginValidation extends JpaRepository<Employee, Integer>{

	public boolean isAdminLoginValid(String username, String password);
	
	public boolean isEmployeeLoginValid(String username, String password);
}
