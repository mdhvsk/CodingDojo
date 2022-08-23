package com.madhavasok.climbing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {
	public RouteController() {
		
	}
	
	@GetMapping("/routes")
	public String routes() {
		return "routes.jsp";
	}
	
	@GetMapping("/routes/show")
	public String showRoute() {
		return "showRoute.jsp";
	}
}
