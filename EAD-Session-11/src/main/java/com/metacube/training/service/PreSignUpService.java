package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EditEmployeeDAO;
import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.dao.JobDAO;
import com.metacube.training.dao.PreSignUpDAO;
import com.metacube.training.dao.ProjectDAO;
import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.PreSignUp;

/**
 * @author Deekshika Sharma
 * This class will have implementation for Pre sign up service 
 */
@Service
public class PreSignUpService implements AdminService<PreSignUp> {

	@Autowired
	PreSignUpDAO preSignUpDAO;
	
	@Autowired
	EditEmployeeDAO employeeDAO;
	
	@Autowired
	ProjectDAO projectDAO;
	
	@Autowired
	JobDAO jobDAO;

	@Override
	public int addField(PreSignUp preSignUp) {
		
		Employee employee = new Employee();
		
		String[] result = preSignUp.getEmailId().split("@");
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
		jobDetails.setJobCode(jobDAO.getJobById(preSignUp.getJobCode()));
		
		String reportingMgr = preSignUp.getReportingMgr();
		String teamLead = preSignUp.getTeamLead();
		Integer projectId = preSignUp.getProjectId();
		
		jobDetails.setReportingMgr(employeeDAO.getFieldById(reportingMgr));
		jobDetails.setTeamLead(employeeDAO.getFieldById(teamLead));
		jobDetails.setProjectId(projectDAO.getProjectById(projectId));
		jobDetails.setTotalExperience(preSignUp.getTotalExp());
		
		return preSignUpDAO.createField(employee, jobDetails);
	}

	@Override
	public int updateField(PreSignUp t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteField(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PreSignUp> retreive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreSignUp getFieldById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
