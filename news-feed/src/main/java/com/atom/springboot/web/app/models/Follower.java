package com.atom.springboot.web.app.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="followers")
public class Follower {
	
	@EmbeddedId
	private FollowersId followersId;
	

	public Follower(FollowersId followersId) {
		this.followersId = followersId;
	}
	
	public Follower() {
		
	}

	public FollowersId getFollowersId() {
		return followersId;
	}

	public void setFollowersId(FollowersId followersId) {
		this.followersId = followersId;
	}
	
	

}
