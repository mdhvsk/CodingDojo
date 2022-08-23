package com.madhavasok.javae.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.madhavasok.javae.models.Course;
import com.madhavasok.javae.models.User;
import com.madhavasok.javae.services.CourseService;
import com.madhavasok.javae.services.UserService;

@Controller
public class CourseController {
	
	private final UserService uServ;
	private final CourseService cServ;

	public CourseController(UserService uServ, CourseService cServ) {
		this.uServ = uServ;
		this.cServ = cServ;
	}
	
	
	@GetMapping("/classes/new")
	public String createPage(HttpSession session, Model model) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		model.addAttribute("course",new Course());

		return "create.jsp";
		
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("course") Course course, BindingResult result, Model model,  HttpSession session) {
		if(result.hasErrors()) { 
			System.out.println("ERRRRRORRRRRRR");
//			model.addAttribute("course",new Course());
			return "create.jsp";
		}
		User user = uServ.getOne((Long)session.getAttribute("uuid"));
		model.addAttribute("user",user);
		course.setUser(user);
		course.setInstructor(user.getFirstName());
		
		
		
		System.out.println(user.getFirstName());
		cServ.createCourse(course);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/course/{id}")
	public String viewCourse(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		model.addAttribute("course", cServ.findCourse(id));
		User user = uServ.getOne((Long)session.getAttribute("uuid"));
		model.addAttribute("user",user);

		return "show.jsp";
	}
	
	
	@GetMapping("/classes/{id}/edit")
	public String editPage(@PathVariable("id") Long id, Model model, HttpSession session ) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		model.addAttribute("currentCourse", cServ.findCourse(id));
		return "edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String editCourse(@Valid @ModelAttribute("currentCourse") Course course, BindingResult result, Model model,  HttpSession session) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) { 

			return "edit.jsp";
		}
		User user = uServ.getOne((Long)session.getAttribute("uuid"));
		course.setUser(user);
		course.setInstructor(user.getFirstName());
		
		cServ.updateCourse(course);
		return "redirect:/dashboard";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		System.out.println("Got to controller");

		cServ.delete(id);

		return "redirect:/dashboard";
	}
	
}
