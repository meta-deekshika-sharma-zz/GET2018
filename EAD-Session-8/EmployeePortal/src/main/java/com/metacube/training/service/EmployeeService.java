package com.metacube.training.service;

import java.util.List;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.model.Employee;

/**
 * @author Deekshika Sharma
 * This class will implements the employee service
 */
public class EmployeeService implements AdminService<Employee> {

	EmployeeDAO employeeDAO = new EmployeeDAO();

	@Override
	public int addField(Employee employee) {
		if (!employeeDAO.isEmailAvailable(employee.getEmailId()))
			return employeeDAO.createField(employee);
		return 0;
	}

	@Override
	public int updateField(Employee employee) {
		if (employeeDAO.isEmailAvailable(employee.getEmailId()))
			return employeeDAO.updateField(employee);
		return 0;
	}

	@Override
	public int deleteField(String id) {
		if (getFieldById(id) != null)
			return employeeDAO.deleteField(id);
		return 0;
	}

	@Override
	public List<Employee> retreive() {
		return employeeDAO.getField();
	}

	@Override
	public Employee getFieldById(String id) {
		return employeeDAO.getFieldById(id);
	}

	public String getCodeByEmail(String email) {
		return employeeDAO.getCodeByEmail(email);
	}

}
