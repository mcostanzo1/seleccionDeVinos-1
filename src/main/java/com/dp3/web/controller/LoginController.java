package com.dp3.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
	
	@GetMapping(value = "/login")
	public ModelAndView login(HttpServletResponse response) {
			ModelAndView model = new ModelAndView("login");
		return model;
	}
	
	@GetMapping(value = "/start")
	public ModelAndView start(HttpServletResponse response) {
		return new ModelAndView("redirect:/products/all");
	}
}
