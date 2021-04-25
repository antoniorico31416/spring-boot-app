package com.atom.springboot.web.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.atom.springboot.web.app.models.Follower;
import com.atom.springboot.web.app.models.FollowersId;
import com.atom.springboot.web.app.models.User;
import com.atom.springboot.web.app.repository.FollowersRepository;
import com.atom.springboot.web.app.repository.UserRepository;
import java.util.Optional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FollowersRepository followersRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public UserService() {
	}
	
	public User addUser(User user) {
		if(userRepository.findByUsername(user.getUserName()) != null) {
			return null;
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(Integer id) {
		return userRepository.findById(id);
	}
	
	public List<User> getUnfollowed(String userName){
		Integer userId = getIdByUsername(userName);
		List<User> usersFollowed = getFollowed(userId);
		List<User> allUsers = getAllUsers();
		List<User> unFollowed = new ArrayList<>(allUsers);
		unFollowed.removeAll(usersFollowed);
		return unFollowed;
	}
	
	public List<User> getFollowed(Integer id){
		List<Integer> usersIds = followersRepository.getFollowed(id);
		List<User> users = new ArrayList<User>();
		
		for(Integer i : usersIds) {
			Optional<User> optUser = userRepository.findById(i);
			User user = optUser.get();
			if(user != null) {
				users.add(user);
			}
		}
		
		return users;
	}
	
	private Integer getIdByUsername(String userName) {
		return userRepository.getIdByUsername(userName);
	}
	
	public Follower followUser(String followed, String follower) {
		Integer followedId = getIdByUsername(followed);
		Integer followerId = getIdByUsername(follower);
		FollowersId followers = new FollowersId(followerId,followedId);
		return followersRepository.save(new Follower(followers));
	}
	
	
	public User getUserByUsername(String userName) {
		return userRepository.findByUsername(userName);
	}
	
	public List<User> getAllExceptCurrentUser(String userName){
		return userRepository.getAllExceptCurrent(userName);
	}
	

}
