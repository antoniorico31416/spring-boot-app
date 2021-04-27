package com.atom.springboot.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.atom.springboot.web.app.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
	
	@Query(value="SELECT * FROM `post` WHERE `userName`=?1 ORDER BY `creation_date` ASC LIMIT ?2",nativeQuery = true)
	List<Post> getLastTenPosts(String userName, Integer numPosts);
	
	@Query(value="SELECT * FROM `post` WHERE `userName`=?1",nativeQuery = true)
	List<Post> getPostsByUserName(String userName);
	
	@Query(value="SELECT * FROM `post` ORDER BY `creation_date` DESC",nativeQuery = true)
	List<Post> getPostsByDate();
	

}
