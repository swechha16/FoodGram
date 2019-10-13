package com.FoodGramServer.FoodGramServer.models;

import javax.persistence.*;

@Entity
@Table(name="User", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "full_name")
	private String full_name;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "account_type", nullable = false)
	private String account_type;
	
	@Column(name = "location_city")
	private String location_city;
	
	@Column(name = "location_state")
	private String location_state;
	
	@Column(name = "phone_no")
	private int phone_no;
	
	@Column(name = "profile_pic")
	private String profile_pic;
	
	public User() {} //basic constructor
	
	public int getId() { return user_id; }
		
	public String getUsername() { return username; }
	
	public void setUsername(String username) { this.username = username; }
	
	public String getName() { return full_name; }
	
	public void setName(String name) { this.full_name = name; }
	
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
	
	public int getPhoneNo() { return phone_no; }
	
	public void setPhoneNo(int phone_no) { this.phone_no = phone_no; }
	
	public String getProfilePic() { return profile_pic; }
	
	public void setProfilePic(String profile_pic) { this.profile_pic = profile_pic; }
	
	
	
}
