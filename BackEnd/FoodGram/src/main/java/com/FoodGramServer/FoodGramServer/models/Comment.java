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
	
	@NotEmpty
	@Column(name = "comment")
	private String comment;
	
	@NotEmpty
	@Column(name = "timestamp")
	private String timestamp;
	
	public Comment() {
		setComment(comment);
		setTimestamp(timestamp);
		setId(id);
	}	
	

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
	
	
	public String toString() 
	{
		return getComment();
	}
}
