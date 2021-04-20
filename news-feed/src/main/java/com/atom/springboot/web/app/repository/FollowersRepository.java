package com.atom.springboot.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atom.springboot.web.app.models.Follower;
import com.atom.springboot.web.app.models.FollowersId;

public interface FollowersRepository extends JpaRepository<Follower, FollowersId>{
	
	@Query(value="SELECT `followed` FROM `followers` WHERE follower=?1",nativeQuery = true)
	List<Integer> getFollowed(Integer follower);

}
