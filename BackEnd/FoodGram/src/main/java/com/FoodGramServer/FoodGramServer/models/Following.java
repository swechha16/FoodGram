package com.FoodGramServer.FoodGramServer.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "following")
public class Following {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long following_id;

	@ManyToMany
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "timestamp")
	@CreationTimestamp
	private LocalDateTime timestamp;

	public long getFollowing_id() {
		return following_id;
	}
 
	public void setFollowing_id(long following_id) {
		this.following_id = following_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
