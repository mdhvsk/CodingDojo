package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
//... imports class definition...
    
    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    private Integer userPin;
    
   
    
    public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
	}
	// TO DO: Implement a constructor that takes an ID and a role --> DONE
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        this.securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    public ArrayList<String> reportSecurityIncidents(){
    	return securityIncidents;
    }
    
    public boolean assignPin(int pin) {
		String pinString = Integer.toString(pin);
		if (pinString.length() >= 6) {
			this.userPin = pin;
			return true;
			
		}
		return false;
	}
    
    public boolean accessAuthorized(Integer access) {
    	if (access == this.pin) {
    		return true;
   
    	}
		this.authIncident();
    	return false;

    	
    }

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}

	public Integer getUserPin() {
		return userPin;
	}

	public void setUserPin(Integer userPin) {
		this.userPin = userPin;
	}
    


    // TO DO: Setters & Getters

}
