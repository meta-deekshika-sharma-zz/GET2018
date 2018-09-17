package com.metacube.training.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.JobDetailsService;
import com.metacube.training.service.JobService;
import com.metacube.training.service.SkillService;

/**
 * @author Deekshika Sharma This class will work for employee controller
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	JobDetailsService jobDetailService;
	
	@Autowired
	SkillService skillService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "employee/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username,
			@RequestParam("password") String password) {

		String view = "employee/dashboard";
		System.out.println("login");
		if (employeeService.findByUsernameAndPassword(username, password) != null)
			view = "employee/dashboard";
		else
			view = "employee/login";

		return new ModelAndView(view, "username", username);
	}

	@RequestMapping(value = "/dashboard")
	public String dashboard() {

		return "employee/dashboard";
	}

	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam("id") String username) {
		return new ModelAndView("employee/editProfile", "employee", employeeService.getEmployeeByCode(username));
	}

	/**
	 * Method used to update the employee profile
	 * @param code
	 * @param fname
	 * @param mname
	 * @param lname
	 * @param email
	 * @param dob
	 * @param skype
	 * @param primaryContactNo
	 * @param secondaryContactNo
	 * @param password
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/editProfile", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@RequestParam("code") String code,
			@RequestParam("fname") String fname,
			@RequestParam("mname") String mname,
			@RequestParam("lname") String lname,
			@RequestParam("email") String email,
			@RequestParam("dob") String dob,
			@RequestParam("skype") String skype,
			@RequestParam("primaryContactNo") String primaryContactNo,
			@RequestParam("secondaryContactNo") String secondaryContactNo,
			@RequestParam("password") String password) throws ParseException {

		Employee employee = new Employee();
		employee.setCode(code);
		employee.setFirstName(fname);
		employee.setLastName(lname);
		employee.setMiddleName(mname);
		employee.setEmailId(email);

		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
		employee.setDob(date);
		employee.setSkypeId(skype);
		employee.setPrimaryContactNo(primaryContactNo);
		employee.setSecondaryContactNo(secondaryContactNo);
		employee.setPassword(password);

		employeeService.updateEmployee(employee);
		return new ModelAndView("employee/dashboard");
	}

	@RequestMapping(value = "/editSkills", method = RequestMethod.GET)
	public ModelAndView editSkills(@RequestParam("id") String username) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("skills", skillService.retreive());
		map.put("id", username);
		return new ModelAndView("employee/editSkills", map);
	}
	
	@RequestMapping(value = "/editSkills", method = RequestMethod.POST)
	public ModelAndView editSkills(@RequestParam("skill") String[] skills, @RequestParam("code") String code) {

		for (String skill : skills)
		{
			Skill skillInstance = new Skill();
			skillInstance.setName(skill);
			skillService.addField(skillInstance);
		}
			
		return new ModelAndView("employee/dashboard");
	}
	
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public String searchEmployee() {

		return "employee/searchEmployee";
	}

	/**
	 * Method used for searching employees based on parameters
	 * @param search
	 * @param select
	 * @return
	 */
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
	public ModelAndView searchEmployee(@RequestParam("search") String search,
			@RequestParam("select") String select) {

		System.out.println("search");
		List<Employee> employees = new ArrayList<Employee>();
		
		employees = jobDetailService.searchEmployeeByProject(search);
		return new ModelAndView("employee/searchResult", "employees", employees);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {

		return new ModelAndView(new RedirectView("../"));
	}
}
