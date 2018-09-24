package com.metacube.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value = "/login/home", method = RequestMethod.GET)
	public ModelAndView homePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Login Successful");
		model.addObject("message", "You are authorised to access this page");
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String adminPage() {
		return "login";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView errorPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Unsuccessful Login");
		model.addObject("message", "You are unauthorised to access this page");
		model.setViewName("error");
		return model;
	}
}