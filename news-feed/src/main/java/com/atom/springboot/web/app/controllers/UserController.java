package com.atom.springboot.web.app.controllers;

import com.atom.springboot.web.app.models.User;
import com.atom.springboot.web.app.services.UserService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping(path = "app/user")
public class UserController {
	
	//Create an instance of service
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/create")
	public String createUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "users/formUser";
	}
	
	@PostMapping("/create")
	public String addUser(User user, Model model) {
		User userCreated = userService.addUser(user);
		String message = "";
		if(userCreated != null) {
			message = "User created";
		}
		else {
			message = "The User '" + user.getUserName() + "' already exists";
		}
		model.addAttribute("message", message);
		model.addAttribute("user", userCreated);
		return "users/creationResult";
	}
	
	@GetMapping("/all")
	public String showAllUsers(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "users/allUsers";
	}
	
	@GetMapping("/unfollowed")
	public String getUnfollowed(Model model) {
		String userName = "atom";
		List<User> users = userService.getUnfollowed(userName);
		if(users != null) {
			
		}
		model.addAttribute("users", users);
		return "users/allUsers";
	}
	
	@GetMapping(value = "follow/{userName}")
	public String followUser(@PathVariable("userName")String userName, Model model) {
		
		return "";
	}

}
