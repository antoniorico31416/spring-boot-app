package com.atom.springboot.web.app.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.atom.springboot.web.app.models.User;
import com.atom.springboot.web.app.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User addUser(User user) {
		if(userRepository.findByUsername(user.getUserName()) != null) {
			return null;
		}
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public List<User> getUnfollowed(String userName){
		Integer userId = getIdByUsername(userName);
		return userRepository.getUnfollowed(userId);
	}
	
	private Integer getIdByUsername(String userName) {
		return userRepository.getIdByUsername(userName);
	}
	

	
	
	

}
