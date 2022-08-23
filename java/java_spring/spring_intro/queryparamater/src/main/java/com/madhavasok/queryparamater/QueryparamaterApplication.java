package com.madhavasok.queryparamater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class QueryparamaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryparamaterApplication.class, args);
	}
	
//	@RequestMapping("/")
//	public String index() {
//		return "Hello Human";
//		
//	}
//	@RequestMapping("/")
//	public String requestName(@RequestParam(value = "q", required = false) String searchQuery) {
//		return searchQuery;
//		
//	}

}
