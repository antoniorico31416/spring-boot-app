package com.atom.springboot.web.app.dao;

import java.util.UUID;

import com.atom.springboot.web.app.models.User;

public interface UserDao {
	
	int insertUser(UUID id, User user);
	
	//User getUser()
	
	default int addUser(User user) {
		UUID id = UUID.randomUUID();
		return insertUser(id, user);
	}

}
