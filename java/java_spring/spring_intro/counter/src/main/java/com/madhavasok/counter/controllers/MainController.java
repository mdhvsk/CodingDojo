package com.madhavasok.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/your_server")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
	        session.setAttribute("count", 0);

		}
		else {
			Integer count = (Integer) session.getAttribute("count");
			session.setAttribute("count", count + 1);
		}
		
		Integer count = (Integer) session.getAttribute("count");
		System.out.println("You visited the homepage: "+ count + " times");
		return "index.jsp";
	}
	
	@RequestMapping("your_server/counter")
	public String counter(HttpSession session, Model model) {
		if(session.getAttribute("count") == null) {
			model.addAttribute("count", 0);
		}
		else {
			Integer count = (Integer) session.getAttribute("count");
			model.addAttribute("count", count);
		}
		return "count.jsp";
		
	}
	
}
