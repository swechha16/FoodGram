package com.FoodGramServer.FoodGramServer.models;

import javax.persistence.*;

@Entity
@Table(name="User", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User {
	private String username;
	private String full_name;
	private String email;
	private String password;
	private String account_type;
	private String location_city;
	private String location_state;
	private int phone_no;
	private String profile_pic;
	
	public User() {
		setUsername(username);
		setFull_name(full_name);
		setEmail(email);
		setPassword(password); 
		setPhone_no(phone_no);
		setProfile_pic(profile_pic);
	} //basic constructor

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getLocation_city() {
		return location_city;
	}

	public void setLocation_city(String location_city) {
		this.location_city = location_city;
	}

	public String getLocation_state() {
		return location_state;
	}

	public void setLocation_state(String location_state) {
		this.location_state = location_state;
	}

	public int getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
	}

	public String getProfile_pic() {
		return profile_pic;
	}

	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}

	
	
	
}
