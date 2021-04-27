package com.atom.springboot.web.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.atom.springboot.web.app.config.MessageResourceImpl;
import com.atom.springboot.web.app.models.User;
import com.atom.springboot.web.app.services.UserService;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@SessionAttributes("user-entity")
public class LoginController {

	// Create an instance of service
	@Autowired
	private UserService userService;
	@Autowired
	private MessageResourceImpl messageSource;
	
	public LoginController() {
		
	}

	@GetMapping("/")
	public String startPage(Model model) {
		model.addAttribute("class", "login");
		return "/auth/login";
	}
	
	@GetMapping("/index")
	String mainPage(Authentication auth, HttpSession session, Model model) {
		String userName = auth.getName();
		
		if(session.getAttribute("user-entity") == null){
			User user = userService.getUserByUsername(userName);
			user.setPassword(null);
			session.setAttribute("user-entity", user);
			model.addAttribute("user",user);
		}
		model.addAttribute("user",userName);
			
		return "index";
	}
	
	//##Login##
	@GetMapping("/auth/login")
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		model.addAttribute("class", "login");
		return "/auth/login";
	}

	//##Registration##
	@GetMapping("/auth/registration")
	public String registrationForm(Model model) {
		User user = new User();

		model.addAttribute("user", user);
		model.addAttribute("class", "registration");
		return "/auth/registration";
	}

	@PostMapping("/auth/registration")
	public String registration(User user, BindingResult result, Model model) {
		String url = null;
		User userCreated = null;
		
		if(result.hasErrors()) {
			model.addAttribute("class", "registration");
			url = "/auth/registration";
		}
		else{
			userCreated = userService.addUser(user);
			model.addAttribute("user", user);
			model.addAttribute("class", "login");
			model.addAttribute("message", messageSource.getMessage("userRegistered"));
			url = "/auth/login";
			
			if(userCreated == null) {
				model.addAttribute("message", messageSource.getMessage("userAlreadyExists"));
				model.addAttribute("class", "registration");
				model.addAttribute("user", user);
				
				url = "/auth/registration";
			}
		}
		
		return url;
	}
}
