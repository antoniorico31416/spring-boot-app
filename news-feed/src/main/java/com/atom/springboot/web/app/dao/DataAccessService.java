package com.atom.springboot.web.app.dao;

import com.atom.springboot.web.app.models.Post;
import com.atom.springboot.web.app.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.atom.springboot.web.app.models.User;

@Repository("dataAccessFake")
public class DataAccessService implements UserDao, PostDao {
	
	//DB for users
	private static HashMap<UUID, User> DB_Users = new HashMap<>();
	//DB for Posts
	private static HashMap<UUID, Post> DB_Posts = new HashMap<>();
	
	@Override
	public int insertUser(UUID id, User user) {
		if(userExists(user.getUserName()) || userExists(id)) {
			return 0;
		}
		//Add user to DB
		User newUser = new User(id, user.getUserName(), user.getEmail());
		DB_Users.put(id, newUser);
		return 1;
	}
	
	public boolean userExists(String userName) {
		//Check if user exists
		for(Map.Entry<UUID, User> entry: DB_Users.entrySet()) {
			if(entry.getValue().getUserName().equals(userName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean userExists(UUID id) {
		//Check if user exists
		if(DB_Users.get(id) != null) {
			return true;
		}
		return false;
	}

	
	//Post Dao methods 
	@Override
	public int insertPost(UUID id, Post post) {
		//Check if user exists
		if(userExists(post.getUserId())) {
			return 0;
		}
		//Add user to DB
		Post newPost = new Post(id, post.getUserId(), post.getContent());
		DB_Posts.put(id, newPost);
		return 1;
	}

}
