package com.madhavasok.daikichiroutes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSPController {
	@RequestMapping("/demo")
	public String demo() {
		return "demo.jsp";
	}
}
