package com.madhavasok.climbing.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.madhavasok.climbing.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService uServ;
	
	public MainController() {
		
	}
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard.jsp";
	}
	
	@GetMapping("/about")
	public String about() {
		return "info.jsp";
	}
	
	
	
}
