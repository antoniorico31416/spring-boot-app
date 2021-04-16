package com.atom.springboot.web.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.atom.springboot.web.app.dao.PostDao;
import com.atom.springboot.web.app.models.Post;

@Service
public class PostService {
	
private final PostDao postDao;
	
	@Autowired
	public PostService(@Qualifier("dataAccessFake") PostDao postDao) {
		this.postDao = postDao;
	}
	
	public int addPost(Post post) {
		return postDao.insertPost(post);
	}
	
	public boolean hasUsers() {
		return postDao.hasUsers();
	}

}
