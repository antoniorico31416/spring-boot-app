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
	public UUID insertUser(User user) {
		if(userExists(user.getUserName())) {
			return null;
		}
		//Add user to DB
		UUID id = UUID.randomUUID();
		User newUser = new User(id, user.getUserName(), user.getEmail());
		DB_Users.put(id, newUser);
		return id;
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
	
	public List<User> getUsers(){
		if(DB_Users.size() > 0) {
			List<User> users = new ArrayList<User>(DB_Users.values());
			return users;
		}
		return null;
	}
	
	@Override
	public User getUser(UUID id) {
		User user = DB_Users.get(id);
		return user;
	}

	
	//Post Dao methods 
	@Override
	public int insertPost(Post post) {
		//Check if user exists
		if(userExists(post.getUserId())) {
			return 0;
		}
		//Add user to DB
		UUID id = UUID.randomUUID();
		Post newPost = new Post(id, post.getUserId(), post.getContent());
		DB_Posts.put(id, newPost);
		return 1;
	}

	@Override
	public boolean hasUsers() {
		return DB_Posts.size() > 0;
	}


}
