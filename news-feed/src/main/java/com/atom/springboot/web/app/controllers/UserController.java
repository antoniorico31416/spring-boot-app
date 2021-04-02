package com.atom.springboot.web.app.controllers;

import com.atom.springboot.web.app.models.User;
import com.atom.springboot.web.app.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "app/user")
public class UserController {
	
	//Create an instance of service
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping(path="/add")
	public void addUser(@RequestBody User user) {
		userService.addUser(user); 
	}

}
