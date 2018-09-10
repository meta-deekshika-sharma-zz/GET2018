package com.metacube.training.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.model.Employee;
import com.metacube.training.model.Job;
import com.metacube.training.model.PreSignUp;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.service.AdminService;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.JobService;
import com.metacube.training.service.PreSignUpService;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.SearchService;
import com.metacube.training.service.SkillService;

/**
 * @author Deekshika Sharma
 * This class will work as admin controller
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username,
			@RequestParam("password") String password) {

		String view;

		if (EmployeeDAO.isValidAdminLogin(username, password))
			view = "admin/dashboard";
		else
			view = "admin/login";

		return new ModelAndView(view, "username", username);
	}

	@RequestMapping(value = "/dashboard")
	public String dashboard() {

		return "admin/dashboard";
	}

	@RequestMapping(value = "/dashboard", params = "username")
	public ModelAndView dashboard(@RequestParam("username") String username) {
		return new ModelAndView("admin/dashboard", "username", username);
	}

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String addProject() {

		return "admin/project";
	}

	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public ModelAndView project(
			@RequestParam("description") String description,
			@RequestParam("startDate") String startDate,
     		@RequestParam("endDate") String endDate,
    		@RequestParam("logo") MultipartFile logo) throws ParseException,
			IOException
			{

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date staDate = simpleDateFormat.parse(startDate);
		Date eDate = simpleDateFormat.parse(endDate);
		Project project = new Project();
		project.setDescription(description);

		if (staDate.after(eDate))
			return new ModelAndView("admin/project");			

		project.setStartDate(staDate);
		project.setEndDate(eDate);
		project.setLogo(logo.getInputStream());
        System.out.println(project);
		ProjectService projectService = new ProjectService();
		projectService.addField(project);

		return new ModelAndView("admin/dashboard");
	}

	@RequestMapping(value = "/skills", method = RequestMethod.GET)
	public String addSkill() {

		return "admin/skills";
	}

	@RequestMapping(value = "/skills", method = RequestMethod.POST)
	public ModelAndView addSkill(@RequestParam("skillName") String skillName) {

		Skill skill = new Skill();
		skill.setName(skillName);
		System.out.println("skills");

		SkillService skillService = new SkillService();
		skillService.addField(skill);

		return new ModelAndView("admin/dashboard");
	}

	@RequestMapping(value = "/jobTitle", method = RequestMethod.GET)
	public String addJobTitle() {

		return "admin/jobTitle";
	}

	@RequestMapping(value = "/jobTitle", method = RequestMethod.POST)
	public ModelAndView addJobTitle(@RequestParam("jobTitle") String jobTitle) {

		Job job = new Job();
		job.setTitle(jobTitle);

		JobService jobService = new JobService();
		jobService.addField(job);
		return new ModelAndView("admin/dashboard");
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmployee() {

		return "admin/addEmployee";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@RequestParam("fname") String firstName,
			@RequestParam("mname") String middleName,
			@RequestParam("lname") String lastName,
			@RequestParam("email") String email,
			@RequestParam("dob") String dob,
			@RequestParam("gender") String gender,
			@RequestParam("doj") String doj,
			@RequestParam("totalExp") String totalExp,
			@RequestParam("jobCode") Integer jobCode,
			@RequestParam("reportingMgr") String reportingMgr,
			@RequestParam("teamLead") String teamLead,
			@RequestParam("projectId") Integer projectId) throws ParseException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dobDate = simpleDateFormat.parse(dob);
		Date dojDate = simpleDateFormat.parse(doj);
		System.out.println("add Employee");
		Double n = Double.parseDouble(totalExp);
		PreSignUp preSignUp = new PreSignUp();
		preSignUp.setFirstName(firstName);
		preSignUp.setMiddleName(middleName);
		preSignUp.setLastName(lastName);
		preSignUp.setEmailId(email);
		preSignUp.setDob(dobDate);
		preSignUp.setDoj(dojDate);
		preSignUp.setGender(gender);

		if (reportingMgr.equals("null"))
			preSignUp.setReportinhMgr(null);
		else
			preSignUp.setReportinhMgr(reportingMgr);

		if (teamLead.equals("null"))
			preSignUp.setTeamLead(null);
		else
			preSignUp.setTeamLead(teamLead);

		if (projectId == null)
			preSignUp.setProjectId(null);
		else
			preSignUp.setProjectId(projectId);
		preSignUp.setTotalExp(n);

		if (jobCode == null)
			preSignUp.setJobCode(null);
		else
			preSignUp.setJobCode(jobCode);

		new PreSignUpService().addField(preSignUp);
		return new ModelAndView("admin/dashboard");
	}

	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public String searchEmployee() {

		return "admin/searchEmployee";
	}

	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
	public ModelAndView searchEmployee(@RequestParam("search") String search,
			@RequestParam("select") String select) {

		SearchService searchService = new SearchService();
		List<Employee> employees = new ArrayList<>();
		if ("name".equals(select)) {
			employees = searchService.searchByName(search);
		} else if ("project".equals(select)) {
			int project_id = Integer.parseInt(search);
			employees = searchService.searchByProject(project_id);
		} else if ("skill".equals(select)) {
			int skill_id = Integer.parseInt(search);
			employees = searchService.searchBySkill(skill_id);
		} else {
			double total_exp = Double.parseDouble(search);
			employees = searchService.searchByTotalExperience(total_exp);
		}

		return new ModelAndView("admin/searchResult", "searchResult", employees);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {

		return new ModelAndView(new RedirectView("../"));
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam("id") String emp_code) {

		EmployeeService employeeService = new EmployeeService();
		Employee employee = employeeService.getFieldById(emp_code);

		return new ModelAndView("admin/UpdateEmployee", "search", employee);
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@RequestParam("fname") String fname,
			@RequestParam("mname") String mname,
			@RequestParam("lname") String lname,
			@RequestParam("email") String email,
			@RequestParam("dob") String dob,
			@RequestParam("skype") String skype,
			@RequestParam("primaryContactNo") String primaryContactNo,
			@RequestParam("secondaryContactNo") String secondaryContactNo)
			throws ParseException {

		Employee employee = new Employee();
		employee.setCode(new EmployeeService().getCodeByEmail(email));
		employee.setFirstName(fname);
		employee.setLastName(lname);
		employee.setMiddleName(mname);
		employee.setEmailId(email);

		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
		employee.setDob(date);
		employee.setSkypeId(skype);
		employee.setPrimaryContactNo(primaryContactNo);
		employee.setSecondaryContactNo(secondaryContactNo);
		System.out.println(new EmployeeService().updateField(employee));
		System.out.println("updated");
		return new ModelAndView("admin/searchResult");
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") String emp_code) {

		EmployeeService employeeService = new EmployeeService();
		System.out.println(employeeService.deleteField(emp_code));

		return new ModelAndView("admin/dashboard");
	}
}
