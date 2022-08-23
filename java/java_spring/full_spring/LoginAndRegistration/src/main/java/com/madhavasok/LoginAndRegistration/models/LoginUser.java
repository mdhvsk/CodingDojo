package com.madhavasok.LoginAndRegistration.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class LoginUser {
	@NotEmpty(message = "Email required")
	@Email(message = "Invalid email format")
	private String email;
	
	@NotEmpty(message = "Password is required")
	@Size(min = 2, max = 256, message = "Password must be between 2 and 256 characters")
	private String password;
	
	public LoginUser() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
