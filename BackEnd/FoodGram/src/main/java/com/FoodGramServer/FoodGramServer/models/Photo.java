package com.FoodGramServer.FoodGramServer.models;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Class that models the entity in the database for a photo object
 * @author alexis
 *
 */
@Entity
@Table(name = "photo")
public class Photo implements Serializable {
    private static final long serialVersionUID = 1L;

	/**
	 * Primary key for photo table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pic_id;
	
	/**
	 * Instance variable for the user that posted the photo
	 */
	@ManyToOne
	//@JsonManagedReference
	@JoinColumn(name="user_id") // specifies to use a column in Photo table to reference user, instead of the default behavior to create a join table
	private User user; //link up with the user table
	
	/**
	 * Picture that user posted 
	 */
	@Column(name = "pic")
	@NotNull
	private String pic;
	
	/**
	 * Caption for the post
	 */
	@Column(name = "caption")
	@NotNull
	private String caption;
	
	/**
	 * Tag for what category of food it is
	 */
	@Column(name = "food_tag")
	@NotNull
	private String food_tag;
	
	/**
	 * Tag for the price range of the food
	 */
	@Column(name = "cost_tag")
	@NotNull
	private String cost_tag;
	
	/**
	 * Tag for what restaurant post is from
	 */
	@Column(name = "restaurant")
	@NotNull
	private String restaurant;
	
	/**
	 * Stores what time the post was posted
	 */
	@Column(name = "timestamp")
	@CreationTimestamp
	private LocalDateTime timestamp;
	
	/**
	 * @return pic_id
	 */
	public long getPicId() { return pic_id; }
	
	/**
	 * sets the pic_id
	 * @param pic_id
	 */
	public void setPicId(long pic_id) { this.pic_id = pic_id; }
	
	/**
	 * @return pic
	 */
	public String getPic() { return pic; }
	
	/**
	 * sets the pic
	 * @param pic
	 */
	public void setPic(String pic) { this.pic = pic; }
	
	/**
	 * @return caption
	 */
	public String getCaption() { return caption; }
	
	/**
	 * sets the caption
	 * @param caption
	 */
	public void setCaption(String caption) { this.caption = caption; }
	
	/**
	 * @return food_tag
	 */
	public String getFoodTag() { return food_tag; } 
	
	/**
	 * sets the food tag
	 * @param food_tag
	 */
	public void setFoodTag(String food_tag) { this.food_tag = food_tag; }
	
	/**
	 * @return cost_tag
	 */
	public String getCostTag() { return cost_tag; }
	
	/**
	 * sets the cost_tag
	 * @param cost_tag
	 */
	public void setCostTag(String cost_tag) { this.cost_tag = cost_tag; }
	
	/**
	 * @return restaurant
	 */
	public String getRestaurant() { return restaurant; }

	/**
	 * sets the restaurant
	 * @param restaurant
	 */
	public void setRestaurant(String restaurant) { this.restaurant = restaurant; }
	
	/**
	 * @return timestamp
	 */
	public LocalDateTime getTimestamp() { return timestamp; }
	
	/**
	 * sets the timestamp
	 * @param timestamp
	 */
	public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

	/**
	 * @return user object
	 */
	public User getUser() {
		return user;
	}

	/**
	 * sets the user who post the pic
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
}
