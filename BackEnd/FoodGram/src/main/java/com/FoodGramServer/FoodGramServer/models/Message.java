package com.FoodGramServer.FoodGramServer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "message")
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_message;


    
@ManyToOne 
@JoinColumn(name="user_id")
//@Column(name="reciever_id")
@JsonManagedReference
private User user; 


//@ManyToOne 
//@JoinColumn(name="reciever_id")
////@Column(name="user_id")
//@JsonManagedReference
//private User user2; 




	

    @Column(name = "message")
    @NotNull
    private String message;


    @Column(name = "timestamp")
    @CreationTimestamp
    private LocalDateTime timestamp;


	public long getId_message() {
		return id_message;
	}


	public void setId_message(long id_message) {
		this.id_message = id_message;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
    




}
