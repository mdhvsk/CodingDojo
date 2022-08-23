package com.madhavasok.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/fortuneSubmit")
	public String fortuneSubmit(
			@RequestParam(value = "years") Integer years, 
			@RequestParam(value = "city") String city, 
			@RequestParam(value = "person") String person, 
			@RequestParam(value = "activity") String activity,
			@RequestParam(value = "living_thing") String living_thing, 
			@RequestParam(value = "message") String message, 
			HttpSession session)
	
	{
		session.setAttribute("years", years);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("activity", activity);
		session.setAttribute("living_thing", living_thing);
		session.setAttribute("message", message);
		return "show.jsp";	
	} 
	
	
	

}