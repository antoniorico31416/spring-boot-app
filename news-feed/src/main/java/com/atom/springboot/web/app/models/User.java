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


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
