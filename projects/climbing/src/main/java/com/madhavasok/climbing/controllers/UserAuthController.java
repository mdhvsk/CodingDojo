package com.madhavasok.climbing.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.madhavasok.climbing.models.LoginUser;
import com.madhavasok.climbing.models.User;
import com.madhavasok.climbing.services.UserService;

@Controller
public class UserAuthController {
	
	@Autowired
	private UserService uServ;
	
	@GetMapping("/loginReg")
	public String loginReg(@ModelAttribute("newUser") User newUser, @ModelAttribute("newLogin") LoginUser newLogin, Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "userAuth.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		User user = uServ.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		
		session.setAttribute("uuid", user.getId());
		
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String register(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = uServ.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "dashboard.jsp";
		}
		session.setAttribute("uuid", user.getId());
		
		return "redirect:/dashboard";
	}
}
