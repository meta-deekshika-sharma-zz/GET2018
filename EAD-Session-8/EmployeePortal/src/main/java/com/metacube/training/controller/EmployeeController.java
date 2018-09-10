package com.metacube.training.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.dao.SearchDAO;
import com.metacube.training.model.Employee;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.SkillService;

/**
 * @author Deekshika Sharma
 * This class will work for employee controller
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "employee/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username,
			@RequestParam("password") String password) {

		String view;

		if (EmployeeDAO.isValidEmployeeLogin(username, password))
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
	public ModelAndView editEmployee(@RequestParam("username") String username) {

		EmployeeService employeeService = new EmployeeService();
		System.out.println(employeeService.getFieldById(username));
		Employee employee = employeeService.getFieldById(username);

		return new ModelAndView("employee/editProfile", "search", employee);
	}

	@RequestMapping(value = "/editProfile", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@RequestParam("fname") String fname,
			@RequestParam("mname") String mname,
			@RequestParam("lname") String lname,
			@RequestParam("email") String email,
			@RequestParam("dob") String dob,
			@RequestParam("skype") String skype,
			@RequestParam("primaryContactNo") String primaryContactNo,
			@RequestParam("secondaryContactNo") String secondaryContactNo,
			@RequestParam("password") String password,
			@RequestParam("skill") String[] skills) throws ParseException {

		Employee employee = new Employee();
		String emp_code = new EmployeeService().getCodeByEmail(email);
		employee.setCode(emp_code);
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
		for(String skill: skills)
			System.out.println("skill" + skill);
		
		new SkillService().insertSkills(skills, emp_code);
		
		return new ModelAndView("employee/dashboard");
	}

	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public String searchEmployee() {

		return "employee/searchEmployee";
	}

	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
	public ModelAndView searchEmployee(@RequestParam("search") String search,
			@RequestParam("select") String select) {

		SearchDAO searchDAO = new SearchDAO();
		List<Employee> employees = new ArrayList<>();
		if ("name".equals(select)) {
			employees = searchDAO.searchByName(search);
		} else if ("project".equals(select)) {
			int project_id = Integer.parseInt(search);
			employees = searchDAO.searchByProject(project_id);
		} else if ("skill".equals(select)) {
			int skill_id = Integer.parseInt(search);
			employees = searchDAO.searchBySkill(skill_id);
		} else {
			double total_exp = Double.parseDouble(search);
			employees = searchDAO.searchByTotalExperience(total_exp);
		}

		return new ModelAndView("employee/searchResult", "searchResult",
				employees);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {

		return new ModelAndView(new RedirectView("../"));
	}
}
