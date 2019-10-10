package com.FoodGramServer.FoodGramServer.models;

import javax.persistence.*;

@Entity
@Table(name="User", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User {
	private int user_id;
	private String username;
	private String full_name;
	private String email;
	private String password;
	private String account_type;
	private String location_city;
	private String location_state;
	private int phone_no;
	private String profile_pic;
	
	public User() {} //basic constructor
	
	
	
}
