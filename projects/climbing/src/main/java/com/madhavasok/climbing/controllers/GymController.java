package com.madhavasok.climbing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GymController {
	
	public GymController() {
		
	}
	
	@GetMapping("/gyms")
	public String gyms() {
		return "gyms.jsp";
	}
	
	@GetMapping("/gyms/show")
	public String showGym() {
		return "showGym.jsp";
	}
}
