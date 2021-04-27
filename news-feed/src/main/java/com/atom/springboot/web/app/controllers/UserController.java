package com.atom.springboot.web.app.controllers;

import com.atom.springboot.web.app.models.User;
import com.atom.springboot.web.app.services.UserService;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user-entity")
@RequestMapping(path = "app/user")
public class UserController {

	// Create an instance of service
	@Autowired
	private UserService userService;

	@Autowired
	public UserController() {
	}

	@GetMapping("/unfollowed")
	public String getUnfollowed(Authentication auth, Model model) {
		String userName = auth.getName();
		List<User> users = userService.getUnfollowed(userName);
		if (users != null) {

		}
		model.addAttribute("users", users);
		model.addAttribute("user",userName);
		return "users/listUsers";
	}

	@GetMapping("/listUnFollowed")
	public String followUser(Authentication auth, Model model) {
		String userName = auth.getName();
		List<User> unFollowed = userService.getUnfollowed(userName);
		model.addAttribute("users", unFollowed);
		model.addAttribute("user",userName);
		
		return "users/followUser";
	}

	@PostMapping("/follow")
	public String followUsers(@RequestParam(value = "userName") String userName, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user-entity");
		userService.followUser(user.getUserName(), userName);
		model.addAttribute("user",user.getUserName());
		return "index";
	}

	@GetMapping("/listFollowed")
	public String followrdUsers(Authentication auth, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user-entity");
		List<User> users = userService.getFollowed(user.getId());
		model.addAttribute("user",auth.getName());

		model.addAttribute("users", users);
		return "users/allUsers";
	}

}
