package com.FoodGramServer.FoodGramServer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "photo")
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pic_id;
	
	// provide values for foreign key 
	// look up many to one annotation
	// rn it says it is not specific for it so it is linking up the wrong thing
	
	
	@ManyToOne
	private User user_id; //link up with the user table
	
	@Column(name = "pic")
	@NotNull
	private String pic;
	
	@Column(name = "caption")
	@NotNull
	private String caption;
	
	@Column(name = "food_tag")
	@NotNull
	private String food_tag;
	
	@Column(name = "cost_tag")
	@NotNull
	private String cost_tag;
	
	@Column(name = "restaurant")
	@NotNull
	private String restaurant;
	
	@Column(name = "timestamp")
	@NotNull
	private String timestamp;
	
	public long getPicId() { return pic_id; }
	
	public void setPicId(long pic_id) { this.pic_id = pic_id;}
	
	public long getUserId() { return user_id.getUserId(); }
	
	public void setUserId(User user_id) { this.user_id = user_id;}
	
	public String getPic() { return pic; }
	
	public void setPic(String pic) { this.pic = pic; }
	
	public String getCaption() { return caption; }
	
	public void setCaption(String caption) { this.caption = caption; }
	
	public String getFoodTag() { return food_tag; } 
	
	public void setFoodTag(String food_tag) { this.food_tag = food_tag; }
	
	public String getCostTag() { return cost_tag; }
	
	public void setCostTag(String cost_tag) { this.cost_tag = cost_tag; }
	
	public String getRestaurant() { return restaurant; }

	public void setRestaurant(String restaurant) { this.restaurant = restaurant; }
	
	public String getTimestamp() { return timestamp; }
	
	public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
	
}
