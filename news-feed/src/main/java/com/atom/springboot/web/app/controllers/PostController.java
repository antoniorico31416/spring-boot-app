package com.atom.springboot.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atom.springboot.web.app.services.PostService;

@RestController
@RequestMapping(path = "app/post")
public class PostController {
	
	//Create an instance of service
	private final PostService postService;
	
	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

}
