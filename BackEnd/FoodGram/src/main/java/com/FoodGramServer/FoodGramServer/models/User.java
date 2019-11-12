package com.FoodGramServer.FoodGramServer.models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *  Class that models the entity in the database for a user object
 * @author Alexis
 *
 */
@Entity
@Table(name="User")
public class User {
	/**
	 * primary key for each user
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	
	// Bidirectional relation with photos. Because it is bidirectional, parsing into json will enter
	// an infinite loop (user->photos->users->...). To resolve this, use @JsonManagedReference and 
	// @JsonBackedReference. Put @JsonManagedReference where you want the entity of the relation to be
	// included in JSON, and @JsonBackedReference where you don't want the entity to be included.
	/**
	 * List of photos that a user has posted
	 */
	@OneToMany(mappedBy = "user") // mappedBy required for bidirectional to indicate the other side
	@JsonBackReference
	private List<Photo> photoPosts;
	
	/**
	 * Username to identify the users
	 */
	@Column(name = "username", nullable = false)
	private String username;
	
	/**
	 * full name of the user
	 */
	@Column(name = "full_name")
	private String full_name;
	
	/**
	 * bio for the user
	 */
	@Column(name = "bio")
	private String bio;
	
	/**
	 * email for the user account
	 */
	@Column(name = "email")
	@NotNull
	private String email;
	
	/**
	 * password for the user account
	 */
	@Column(name = "password")
	@NotNull
	private String password;
	
	/**
	 * type of account (user/restaurant)
	 */
	@Column(name = "account_type")
	@NotNull
	private String account_type;
	
	/**
	 * location of the user
	 */
	@Column(name = "location_city")
	private String location_city;
	
	/**
	 * location state of the user
	 */
	@Column(name = "location_state")
	private String location_state;
	
	/**
	 * phone number of the user
	 */
	@Column(name = "phone_no")
	private String phone_no;
	
	/**
	 * picture of the user 
	 */
	@Column(name = "profile_pic")
	private String profile_pic;
		
	/**
	 * 
	 * @return
	 */
	public long getUserId() { return user_id; }
	
	/**
	 * 
	 * @param user_id
	 */
	public void setUserId(long user_id) { this.user_id = user_id; }
	
	/**
	 * 
	 * @return
	 */
	public String getUsername() { return username; }

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) { this.username = username; }

	/**
	 * 
	 * @return
	 */
	public String getFullName() { return full_name; }

	/**
	 * 
	 * @param full_name
	 */
	public void setFullName(String full_name) { this.full_name = full_name; }
	
	/**
	 * 
	 * @return
	 */
	public String getBio() { return bio; }
	
	/**
	 * 
	 * @param bio
	 */
	public void setBio(String bio) { this.bio = bio; }

	/**
	 * 
	 * @return
	 */
	public String getEmail() { return email; }

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) { this.email = email; }

	/**
	 * 
	 * @return
	 */
	public String getPassword() { return password; }

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) { this.password = password; }

	/**
	 * 
	 * @return
	 */
	public String getAccountType() { return account_type; }

	/**
	 * 
	 * @param account_type
	 */
	public void setAccountType(String account_type) { this.account_type = account_type; }

	/**
	 * 
	 * @return
	 */
	public String getLocationCity() { return location_city; }

	/**
	 * 
	 * @param location_city
	 */
	public void setLocationCity(String location_city) { this.location_city = location_city; }

	/**
	 * 
	 * @return
	 */
	public String getLocationState() { return location_state; }

	/**
	 * 
	 * @param location_state
	 */
	public void setLocationState(String location_state) { this.location_state = location_state; }

	/**
	 * 
	 * @return
	 */
	public String getPhoneNo() { return phone_no; }

	/**
	 * 
	 * @param phone_no
	 */
	public void setPhoneNo(String phone_no) { this.phone_no = phone_no; }

	/**
	 * 
	 * @return
	 */
	public String getProfilePic() { return profile_pic; }

	/**
	 * 
	 * @param profile_pic
	 */
	public void setProfilePic(String profile_pic) { this.profile_pic = profile_pic; }

	/**
	 * 
	 * @return
	 */
	public List<Photo> getPhotoPosts() {
		return photoPosts;
	}

	/**
	 * 
	 * @param photoPosts
	 */
	public void setPhotoPosts(List<Photo> photoPosts) {
		this.photoPosts = photoPosts;
	}

}
