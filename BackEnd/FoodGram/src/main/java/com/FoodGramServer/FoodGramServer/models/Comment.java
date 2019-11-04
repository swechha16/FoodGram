package com.FoodGramServer.FoodGramServer.models;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.lang.*;



@Entity
@Table(name = "comment")
public class Comment{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "timestamp")
	private String timestamp;
	
	@ManyToOne
	//@JsonManagedReference //Who added this I am unsure on what it does? --AC
	@JoinColumn(name="user_id") // specifies to use a column in Photo table to reference user, instead of the default behavior to create a join table
	private User user;
	
	@ManyToOne
	@JoinColumn(name="pic_id")
	private Photo photo;
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	} 
	
	public Photo getPhoto() {
		return photo;
	}
	
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
