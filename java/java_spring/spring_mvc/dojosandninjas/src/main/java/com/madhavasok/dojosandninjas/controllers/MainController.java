package com.madhavasok.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.madhavasok.dojosandninjas.models.Dojo;
import com.madhavasok.dojosandninjas.models.Ninja;
import com.madhavasok.dojosandninjas.services.DojoService;
import com.madhavasok.dojosandninjas.services.NinjaService;

@Controller
public class MainController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	public MainController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@GetMapping("/dojos/new")
	public String createDojoPage(Model model) {
		model.addAttribute("dojo", new Dojo());
		return "newDojo.jsp";
	}
	
	
	@GetMapping("/ninjas/new")
	public String createNinjaPage(Model model) {
		model.addAttribute("ninja", new Ninja());
		model.addAttribute("allDojos", dojoService.allDojos());
		System.out.println(model.getAttribute("allDojos"));
		return "newNinja.jsp";
	}
	
	
	@GetMapping("/dojos/{id}")
	public String dojoPage(Model model, @PathVariable("id") Long id) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		model.addAttribute("allNinjas", ninjaService.allNinjas());
		return "dojo.jsp";
		
	}
	

	@PostMapping("/dojos/createDojo")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		dojoService.createDojo(dojo);
		return "redirect:/dojos/new";

	}
	
	@PostMapping("/ninjas/createNinja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		}
		ninjaService.createNinja(ninja);
		return "redirect:/ninjas/new";
	}
	
	
	
}
