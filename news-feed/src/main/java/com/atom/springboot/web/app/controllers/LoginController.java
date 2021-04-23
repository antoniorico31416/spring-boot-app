package com.atom.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String startPage() {
		return "login";
	}
	
	@GetMapping("/auth/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/auth/registration")
	public String registration() {
		return "registration";
	}
}
