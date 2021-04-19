package com.atom.springboot.web.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.atom.springboot.web.app.models.Post; 	
import com.atom.springboot.web.app.repository.PostRepository;

@Service
public class PostService {
	
private final PostRepository postRepository;
	
	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public Post addPost(Post post) {
		return postRepository.save(post);
	}

}
