package com.FoodGramServer.FoodGramServer.models;

import javax.persistence.Column;

public class Comment {

	// define the parameters that are in the database (columns)
	
	// get and set 
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "timestamp")
	private String timestamp;
	
	@Column(name = "id")
	private long id;

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
	
	
	
	
}
