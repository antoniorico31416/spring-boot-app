package com.atom.springboot.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.atom.springboot.web.app.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
	
	@Query(value="SELECT * FROM `post` WHERE `user_id`=?1 ORDER BY `creation_date` ASC LIMIT 10",nativeQuery = true)
	List<Post> getLastTenPosts(Integer id);
	

}
