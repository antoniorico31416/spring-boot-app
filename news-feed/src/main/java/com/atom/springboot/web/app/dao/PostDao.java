package com.atom.springboot.web.app.dao;

import java.util.UUID;
import com.atom.springboot.web.app.models.Post;

public interface PostDao {
	
int insertPost(Post post);
boolean hasUsers();

}
