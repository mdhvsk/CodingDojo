package com.madhavasok.queryparamater;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@RequestMapping("/")
	public String requestName(@RequestParam (required = false) String firstName, @RequestParam(required = false) String lastName ) {

		if (firstName != null) {
			return  "First Name: "+ firstName + "Last Name: "+ lastName;
		}
		
		return "Hello Human";
	}
	
}
