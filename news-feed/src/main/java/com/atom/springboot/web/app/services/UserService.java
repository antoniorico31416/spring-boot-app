package com.atom.springboot.web.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.atom.springboot.web.app.dao.UserDao;
import com.atom.springboot.web.app.models.User;

@Service
public class UserService {
	
	private final UserDao userDao;
	
	@Autowired
	public UserService(@Qualifier("userDataAccessFake") UserDao userDao) {
		this.userDao = userDao;
	}
	
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	
	
	

}
