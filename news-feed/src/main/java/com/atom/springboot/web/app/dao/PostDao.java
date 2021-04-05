package com.atom.springboot.web.app.dao;

import java.util.UUID;
import com.atom.springboot.web.app.models.Post;

public interface PostDao {
	
int insertPost(UUID id, Post post);
	
	//User getUser()
	default int addUser(Post post) {
		UUID id = UUID.randomUUID();
		return insertPost(id, post);
	}

}
