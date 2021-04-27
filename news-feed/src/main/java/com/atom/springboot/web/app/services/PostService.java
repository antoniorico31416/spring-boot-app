package com.atom.springboot.web.app.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.atom.springboot.web.app.models.Post;
import com.atom.springboot.web.app.models.User;
import com.atom.springboot.web.app.repository.PostRepository;
import com.atom.springboot.web.app.repository.UserRepository;

@Service
public class PostService {
	private PostRepository postRepository;
	private UserService userService;
	
	@Autowired
	public PostService(PostRepository postRepository, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}
	
	public PostService() {
	}
	
	public Post addPost(Post post) {
		return postRepository.save(post);
	}
	
	public List<Post> getLastPosts(Integer userId, int numPosts){
		System.out.println("Id: " + userId);
		List<User> usersFollowed = userService.getFollowed(userId);
		System.out.println("Paso");
		//Convert usersFollowed in hashmap 
		Map<String, User> userMap = new HashMap<>();
		for(User user : usersFollowed){
			userMap.put(user.getUserName(), user);
	    }
		
		List<Post> allPosts = postRepository.getPostsByDate();
		List<Post> recentNews = new ArrayList<Post>();
		
		for(Post post: allPosts) {
			if(userMap.containsKey(post.getUserName())) {
				recentNews.add(post);
			}
			
			if(recentNews.size() == numPosts) {
				break;
			}
		}
		
		
		return recentNews;
	}

}
