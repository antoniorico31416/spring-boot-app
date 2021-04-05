package com.atom.springboot.web.app.models;

import java.util.UUID;

public class Post {
	
	private UUID id;
	private UUID userId;
	private String content; 

	public Post(UUID id, UUID userId, String content) {
		this.id = id;
		this.userId = userId;
		this.content = content;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
