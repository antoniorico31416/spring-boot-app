package com.atom.springboot.web.app.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FollowersId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "followed")
	private Integer followed;
	
	@Column(name = "follower")
	private Integer	follower;

	public FollowersId(Integer followed, Integer follower) {
		this.followed = followed;
		this.follower = follower;
	}
	
	public FollowersId() {
	}

	public Integer getFollowed() {
		return followed;
	}

	public void setFollowed(Integer followed) {
		this.followed = followed;
	}

	public Integer getFollower() {
		return follower;
	}

	public void setFollower(Integer follower) {
		this.follower = follower;
	}

}
