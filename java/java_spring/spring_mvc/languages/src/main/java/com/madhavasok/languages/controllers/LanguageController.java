package com.madhavasok.languages.controllers;

import java.util.List;

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

import com.madhavasok.languages.models.Language;
import com.madhavasok.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController (LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/")
	public String index() {
		return "redirect:/languages";
	}
	
	@GetMapping("/languages")
	public String languages(Model model) {
		List<Language> listOfLanguages = languageService.allLanguages();
		model.addAttribute("language", new Language());
		model.addAttribute("languages", listOfLanguages);
		return "languages.jsp";
	}
	
	@GetMapping("/languages/show/{id}")
	public String showLanguage(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "show.jsp";

	}
	
	@PostMapping("/languages/create")
	public String createLanguage(@Valid @ModelAttribute("language") Language language, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "languages.jsp";
		}
		languageService.createLanguage(language);
		System.out.println("Successful");

		return "redirect:/languages";
	}
	
	@GetMapping("/languages/editPage/{id}")
	public String editLanguagePage(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	@PutMapping("/languages/edit/{id}")
	public String editLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		languageService.updateLanguage(language);
		return "redirect:/languages";
	}
	
	@DeleteMapping("languages/delete/{id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
		System.out.println("Here");
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	
	
}

