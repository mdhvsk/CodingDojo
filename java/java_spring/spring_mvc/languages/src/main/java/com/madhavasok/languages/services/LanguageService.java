package com.madhavasok.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.madhavasok.languages.models.Language;
import com.madhavasok.languages.repositories.LanguageRepository;

@Service
public class LanguageService {

	private final LanguageRepository languageRepo;
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	public List<Language> allLanguages(){
		return this.languageRepo.findAll();
	}
	
	public Language createLanguage(Language language) {
		return languageRepo.save(language);
	}
	
	public Language findLanguage(long id) {
		Optional<Language> optionalLanguage = languageRepo.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}
		return null;
	}
	
	public Language updateLanguage(Language language) {
		return languageRepo.save(language);
	}
	
	public void deleteLanguage(long id) {
		languageRepo.deleteById(id);
	}
	
	
}
