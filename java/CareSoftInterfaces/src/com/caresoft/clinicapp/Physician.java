package com.caresoft.clinicapp;

public class Physician extends User implements HIPAACompliantUser {
	int userPin;
	public Physician (Integer id) {
		super(id);
	
		
	}
	
	public boolean assignPin(int pin) {
		String pinString = Integer.toString(pin);
		if (pinString.length() == 4) {
			this.userPin = pin;
			return true;
			
		}
		return false;
	}
	
	public boolean accessAuthorized(Integer id) {
		if(this.id == id) {
			return true;
		}
		return false;
	}

}
