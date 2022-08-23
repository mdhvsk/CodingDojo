package com.madhavasok.ninjagoldgame.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Random;

@Controller
public class HomeController {

	@RequestMapping("/gold")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
	        session.setAttribute("count", 0);

		}
		
		return "index.jsp";
	}
	
	@RequestMapping(value = "/findGold", method = RequestMethod.POST)
	public String findGold(
			@RequestParam(value = "selection") String selection,
			HttpSession session
			) {
		Integer randomGold;
		Random random = new Random();
		Integer result;
		if (session.getAttribute("count") == null) {
	        session.setAttribute("count", 0);

		}
	
		if (selection.equals("farm")) {
			randomGold = random.nextInt(11) + 10;
			System.out.println(randomGold);
			
			
		}
		else if (selection.equals("cave")){
			randomGold = random.nextInt(11) + 10;
			System.out.println(randomGold);
		}
		else if (selection.equals("house")) {
			randomGold = random.nextInt(11) + 10;
			System.out.println(randomGold);
		}
		else {
			result = random.nextInt(2);
			randomGold = random.nextInt(11) + 10;
			System.out.println(result);

			if (result.equals(1)) {
				randomGold = randomGold * -1;
			}
			
			System.out.println(randomGold);
		}
		
		Integer currentCount = (Integer) session.getAttribute("count");
		session.setAttribute("count", currentCount + randomGold);
		
		return "redirect:/gold";
	}
}