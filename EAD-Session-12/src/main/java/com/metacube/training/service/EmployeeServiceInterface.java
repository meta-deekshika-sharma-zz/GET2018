package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Employee;
import com.metacube.training.model.PreSignUp;

public interface EmployeeServiceInterface {

	public int addEmployee(PreSignUp preSignUp);
	
	public int updateEmployee(Employee employee);
	
	public int deleteEmployee(Employee employee);
	
	public List<Employee> getEmployeeList();
	
	public String findByUsernameAndPassword(String emp_code, String password);

	Employee getEmployeeByCode(String empCode);
}
