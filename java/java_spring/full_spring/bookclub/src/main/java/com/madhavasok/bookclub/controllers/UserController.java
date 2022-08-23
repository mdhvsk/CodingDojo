package com.madhavasok.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.madhavasok.bookclub.models.LoginUser;
import com.madhavasok.bookclub.models.User;
import com.madhavasok.bookclub.services.BookService;
import com.madhavasok.bookclub.services.UserService;

@Controller
public class UserController {
	
	
	private final UserService uServ;
	private final BookService bServ;
	
	public UserController(UserService uServ, BookService bServ) {
		this.uServ = uServ;
		this.bServ = bServ;
	}
	
	@GetMapping("/")
	public String index(@ModelAttribute("newUser") User newUser, @ModelAttribute("newLogin") LoginUser newLogin, Model model){
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";	
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
			return "index.jsp";
		}
		session.setAttribute("uuid", user.getId());
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("uuid");
		return "redirect:/";
		
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		User user = uServ.getOne((Long)session.getAttribute("uuid"));
		model.addAttribute("user",user);
		
		model.addAttribute("allBooks", bServ.allBooks());
		System.out.println(session.getAttribute("uuid"));
		return "dashboard.jsp";
	}
	
	
	
}