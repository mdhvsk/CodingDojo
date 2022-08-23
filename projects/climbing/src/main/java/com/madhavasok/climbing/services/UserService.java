package com.madhavasok.climbing.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.madhavasok.climbing.models.LoginUser;
import com.madhavasok.climbing.models.User;
import com.madhavasok.climbing.repositories.UserRepo;

@Service()
public class UserService {
	@Autowired
	private UserRepo uRepo;
	
//	Register and Login
	public User register(User newUser, BindingResult result) {
		if(uRepo.findByEmail(newUser.getEmail()).isPresent()){
			result.rejectValue("email", "Unique", "Email is already in use");
		}
		 
		if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "Matches", "The Confirm Password must match Password!");
		}
		
		if (result.hasErrors()){
			return null;
		}
		
		String hash_browns = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hash_browns);
		return uRepo.save(newUser);
	}
	
	public User login(LoginUser newLoginUser, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		
		Optional<User> potentialUser = uRepo.findByEmail(newLoginUser.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "Unique", "Invalid Credentials");
			return null;
		}
		
		User user = potentialUser.get();
		if(BCrypt.checkpw(newLoginUser.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Credentials");
			return null;
		}
		return user;
	}
	
	

//	Read
	public User getOne(Long id) {
		return uRepo.findById(id).orElse(null);
	}
	
}