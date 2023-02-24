package com.salesken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentControllerUi {

	@GetMapping("/home")
	public String homeMethod() {
		return "home.jsp";
	}
}
