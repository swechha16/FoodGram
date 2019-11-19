package com.FoodGramServer.FoodGramServer.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "Following")
public class Following implements Serializable{
    private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long following_id;

	@ManyToOne
	@JsonBackReference(value = "userFollowing")
	@JoinColumn(name = "follow_id")
	private User follow;

	@ManyToOne
	@JsonBackReference(value = "userFollower")
	@JoinColumn(name = "follower_id")
	private User follower;

	@Column(name = "timestamp")
	@CreationTimestamp
	private LocalDateTime timestamp;

	public Following()
	{
		
	}
	
	public Following(long following_id, User follower, User follow) {
		this.following_id = following_id;
		this.follower = follower;
		this.follow = follow;
	}
	
	public long getFollowing_id() {
		return following_id;
	}

	public void setFollowing_id(long following_id) {
		this.following_id = following_id;
	}

	public User getUser() {
		return follow;
	}

	public void setUser(User following) {
		this.follow = following;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public User getFollower() {
		return follower;
	}

	public void setFollower(User follower) {
		this.follower = follower;
	}

}
