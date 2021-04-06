package com.atom.springboot.web.app.models;

import java.util.List;
import java.util.UUID;

public class User {
	
	private UUID id;
	private String userName;
	private String email;
	private List<UUID> usersFollowed;
	
	
	public List<UUID> getUsersFollowed() {
		return usersFollowed;
	}


	public void setUsersFollowed(List<UUID> usersFollowed) {
		this.usersFollowed = usersFollowed;
	}


	public User(UUID id, String userName, String email) {
		this.id = id;
		this.userName = userName;
		this.email = email;
	}
	
	public User() {
		
	}


	public UUID getId() {
		return this.id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getUserName() {
		return this.userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return this.email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
