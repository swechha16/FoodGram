package com.FoodGramServer.FoodGramServer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_message;




	@ManyToOne
	//@JsonManagedReference 
	@JoinColumn(name="user_id") 
	private User[] user; 

	
	
	@Column(name="user1")
	private String user1; 
	

	@Column(name="user2")
	private String user2; 
	

    @Column(name = "message")
    @NotNull
    private Message message;

    @Column(name = "timestamp")
    @NotNull
    private LocalDateTime timestamp;
    

	public User[] getUser() {
		return user;
	}

	public void setUser(User[] user) {
		this.user = user;
	}

	public String getUser1() {
		return user1;
	}

	public void setUser1(String user1) {
		this.user1 = user1;
	}

	public String getUser2() {
		return user2;
	}

	public void setUser2(String user2) {
		this.user2 = user2;
	}
	public long getId_message() {
		return id_message;
	}

	public void setId_message(long id_message) {
		this.id_message = id_message;
	}



	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message2) {
		this.message = message2;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}




}
