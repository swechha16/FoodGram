package com.FoodGramServer.FoodGramServer.models;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;

import java.lang.*;
import java.time.LocalDateTime;

/**
 * Class for comment
 * 
 * @author Swechha
 *
 */
@Entity
@Table(name = "comment")
public class Comment {
	/**
	 * primary key comments
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/**
	 * String that contain actual comment
	 */
	@Column(name = "comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="user_id") // specifies to use a column in Photo table to reference user, instead of the default behavior to create a join table
	private User user;
	
	@ManyToOne
	@JoinColumn(name="pic_id")
	private Photo photo;
	

	/**
	 * Create generate timestamp for when comment was posted
	 */
	@CreationTimestamp
	private LocalDateTime timestamp;

	/**
	 * @return timestamp
	 */
	public LocalDateTime getTimestamp() {	return timestamp;	}

	/**
	 * sets timestamp
	 * @param timestamp
	 */
	public void setTimestamp(LocalDateTime timestamp) {	this.timestamp = timestamp;		}

	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * sets the comment id
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * sets the string comment
	 * @param comment
	 */
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
