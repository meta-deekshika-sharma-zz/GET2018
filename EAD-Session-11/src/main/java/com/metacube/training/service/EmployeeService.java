package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EditEmployeeDAO;
import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.model.Employee;

/**
 * @author Deekshika Sharma
 * This class will implements the employee service
 */
@Service
public class EmployeeService implements AdminService<Employee> {

	@Autowired
	EditEmployeeDAO employeeDAO;

	@Override
	public int addField(Employee employee) {
		if (employeeDAO.isEmailAvailable(employee.getEmailId()) == null)
			return employeeDAO.createField(employee);
		return 0;
	}

	@Override
	public int updateField(Employee employee) {
		return employeeDAO.updateField(employee);
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
		Employee employee = employeeDAO.isEmailAvailable(email);
		return employee.getCode();
	}

	public String getPassword(String email)
	{
		Employee employee =  employeeDAO.isEmailAvailable(email);
		return employee.getPassword();
	}
}
