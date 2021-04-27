package com.atom.springboot.web.app.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;

import com.atom.springboot.web.app.config.MessageResourceImpl;
import com.atom.springboot.web.app.models.Post;
import com.atom.springboot.web.app.models.User;
import com.atom.springboot.web.app.services.PostService;

@Controller
@SessionAttributes("user-entity")
@RequestMapping(path = "app/post")
public class PostController {
	
	//Create an instance of service
	@Autowired
	private PostService postService;
	@Autowired
	private MessageResourceImpl messageSource;

	public PostController() {
	}
	
	@GetMapping("/create")
	public String formPost(Authentication auth, Model model) {
		Post post = new Post();
		
		model.addAttribute("post",post);
		model.addAttribute("user",auth.getName());
		return "posts/formPost";
	}
	
	@PostMapping("/create")
	public String createPost(Authentication auth, Post post, Model model, HttpSession session) {
		User userLogged = (User) session.getAttribute("user-entity");
		String userName = auth.getName();
		post.setUserId(userLogged.getId());
		post.setUserName(userName);
		Post postCreated = postService.addPost(post);
		
		String message = "";
		if(postCreated != null) {
			message = messageSource.getMessage("postCreated");
		}
		else {
			message = messageSource.getMessage("postCreationError");
			post = null;
		}
		model.addAttribute("post", post);
		model.addAttribute("message", message);
		model.addAttribute("user",userName);
		return "posts/creationResult";
	}
	
	@GetMapping("/newsFeed")
	public String getNewsFeed(Authentication auth, Model model, HttpSession session) {
		String userName = auth.getName();
		User userLogged = (User) session.getAttribute("user-entity");
		List<Post> posts = null;
		//Get last 10 posts
		posts = postService.getLastPosts(userLogged.getId(),10);
		model.addAttribute("user",userName);
		
		model.addAttribute("posts",posts);
		return "posts/getNewsFeed";
	}

}
