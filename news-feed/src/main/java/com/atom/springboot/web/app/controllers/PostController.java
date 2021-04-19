package com.atom.springboot.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.atom.springboot.web.app.models.Post;
import com.atom.springboot.web.app.services.PostService;

@Controller
@RequestMapping(path = "app/post")
public class PostController {
	
	//Create an instance of service
	private final PostService postService;
	
	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/all")
	public String showAllPosts(Model model) {
		//model.addAttribute("posts", );
		return "posts/allPosts";
	}

}
