package com.atom.springboot.web.app.dao;

import com.atom.springboot.web.app.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.atom.springboot.web.app.models.User;

@Repository("userDataAccessFake")
public class UserDataAccessService implements UserDao {
	
	//private static List<User> DB = new ArrayList<>();
	private static HashMap<UUID, User> DB = new HashMap<>();
	
	@Override
	public int insertUser(UUID id, User user) {
		if(userExists(user.getUserName()) || userExists(id)) {
			return 0;
		}
		//Add user to DB
		User newUser = new User(id, user.getUserName(), user.getEmail());
		DB.put(id, newUser);
		return 1;
	}
	
	public boolean userExists(String userName) {
		//Check if user exists
		for(Map.Entry<UUID, User> entry: DB.entrySet()) {
			if(entry.getValue().getUserName().equals(userName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean userExists(UUID id) {
		//Check if user exists
		if(DB.get(id) != null) {
			return true;
		}
		return false;
	}

}
