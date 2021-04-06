package com.atom.springboot.web.app.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.atom.springboot.web.app.dao.UserDao;
import com.atom.springboot.web.app.models.User;

@Service
public class UserService {
	
	private final UserDao userDao;
	
	@Autowired
	public UserService(@Qualifier("dataAccessFake") UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UUID addUser(User user) {
		return userDao.insertUser(user);
	}
	
	public List<User> getAllUsers(){
		return userDao.getUsers();
	}
	
	public User getUser(UUID id) {
		return userDao.getUser(id);
	}

	
	
	

}
