package com.atom.springboot.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.atom.springboot.web.app.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value="SELECT * FROM `user` WHERE username=?1",nativeQuery = true)
	User findByUsername(String username);
	
	@Query(value="SELECT * FROM `followers` WHERE followed=?1",nativeQuery = true)
	List<User> getUnfollowed(Integer user_id);
	
	@Query(value="SELECT user_id FROM `user` WHERE username=?1",nativeQuery = true)
	Integer getIdByUsername(String userName);

}
