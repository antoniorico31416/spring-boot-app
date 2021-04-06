package com.atom.springboot.web.app.dao;

import java.util.List;
import java.util.UUID;

import com.atom.springboot.web.app.models.User;

public interface UserDao {
	
	UUID insertUser(User user);
	List<User> getUsers();
	User getUser(UUID id); 
	
	

}
