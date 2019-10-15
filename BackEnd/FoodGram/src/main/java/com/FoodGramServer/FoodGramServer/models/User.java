package com.FoodGramServer.FoodGramServer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="User", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_id;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "full_name")
	private String full_name;
	
	@Column(name = "bio")
	private String bio;
	
	@Column(name = "email")
	@NotNull
	private String email;
	
	@Column(name = "password")
	@NotNull
	private String password;
	
	@Column(name = "account_type")
	@NotNull
	private String account_type;
	
	@Column(name = "location_city")
	private String location_city;
	
	@Column(name = "location_state")
	private String location_state;
	
	@Column(name = "phone_no")
	private String phone_no;
	
	@Column(name = "profile_pic")
	private String profile_pic;
	
	public User() {
		setUsername(username);
		setFullName(full_name);
		setEmail(email);
		setPassword(password); 
		setPhoneNo(phone_no);
		setProfilePic(profile_pic);
	} //basic constructor

	public long getUserId() { return user_id; }
	
	public void setUserId(long user_id) { this.user_id = user_id; }
	
	public String getUsername() { return username; }

	public void setUsername(String username) { this.username = username; }

	public String getFullName() { return full_name; }

	public void setFullName(String full_name) { this.full_name = full_name; }
	
	public String getBio() { return bio; }
	
	public void setBio(String bio) { this.bio = bio; }

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }

	public String getAccountType() { return account_type; }

	public void setAccountType(String account_type) { this.account_type = account_type; }

	public String getLocationCity() { return location_city; }

	public void setLocationCity(String location_city) { this.location_city = location_city; }

	public String getLocationState() { return location_state; }

	public void setLocationState(String location_state) { this.location_state = location_state; }

	public String getPhoneNo() { return phone_no; }

	public void setPhoneNo(String phone_no) { this.phone_no = phone_no; }

	public String getProfilePic() { return profile_pic; }

	public void setProfilePic(String profile_pic) { this.profile_pic = profile_pic; }

<<<<<<< HEAD

=======
	
>>>>>>> c24c99f882a586fa8f7dc4ebd3b440b5962d784b
}
