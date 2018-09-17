package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.PreSignUp;
import com.metacube.training.repository.EmployeeRepository;
import com.metacube.training.repository.JobDetailRepository;

/**
 * @author Deekshika Sharma
 * This class will implements the employee service
 */
@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepository<Employee> employeeRepository;
	
	@Autowired
	private JobDetailRepository<JobDetails> jobDetailsRepository;
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private ProjectService projectService;
	
	@Override
	public int addEmployee(PreSignUp preSignUp) {
		
		String email = preSignUp.getEmailId();
		String[] result = email.split("@");
		Employee employee = new Employee();
		employee.setCode(result[0]);
		employee.setPassword("123456");
		employee.setFirstName(preSignUp.getFirstName());
		employee.setMiddleName(preSignUp.getMiddleName());
		employee.setLastName(preSignUp.getLastName());
		employee.setEmailId(preSignUp.getEmailId());
		employee.setDob(preSignUp.getDob());
		employee.setGender(preSignUp.getGender());
		employee.setEnabled(true);
		
		JobDetails jobDetails = new JobDetails();
		jobDetails.setDateOfJoining(preSignUp.getDoj());
		jobDetails.setEmployeeCode(employee);
		jobDetails.setJobCode(jobService.getJobTitleById(preSignUp.getJobCode()));
		jobDetails.setProjectId(projectService.getProjectById(preSignUp.getProjectId()));
		jobDetails.setReportingMgr(getEmployeeByCode(preSignUp.getCode()));
		jobDetails.setTeamLead(getEmployeeByCode(preSignUp.getTeamLead()));
		jobDetails.setTotalExperience(preSignUp.getTotalExp());
		
		employeeRepository.save(employee);
		jobDetailsRepository.save(jobDetails);
		return 1;
	}

	@Override
	public int updateEmployee(Employee employee) {
		employeeRepository.saveAndFlush(employee);
		return 1;
	}

	@Override
	public int deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
		return 0;
	}

	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByCode(String empCode) {
		return employeeRepository.findByUsername(empCode);
	}

	@Override
	public String findByUsernameAndPassword(String emp_code, String password) {
		return employeeRepository.findByUsernameAndPassword(emp_code, password);
	}

}
