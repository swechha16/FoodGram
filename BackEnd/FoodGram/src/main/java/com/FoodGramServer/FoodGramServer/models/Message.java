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
    public Message(long id_message,  @NotNull String message, LocalDateTime timestamp, User sender, User receiver) {

		this.id_message = id_message;
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
		this.timestamp = timestamp;
	}

	private static final long serialVersionUID = 1L;
    

    public Message() { 
    	
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_message;


    //user id 1 = sender
    @ManyToOne
	@JoinColumn(name = "sender_id")
	private User sender;
	
    
    //user_id2
	@ManyToOne
	@JoinColumn(name = "receiver_id")
	private User receiver;

	

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


	public User getSender() {
		return sender;
	}


	public void setSender(User sender) {
		this.sender = sender;
	}


	public User getReciever() {
		return receiver;
	}


	public void setReciever(User reciever) {
		this.receiver = reciever;
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
