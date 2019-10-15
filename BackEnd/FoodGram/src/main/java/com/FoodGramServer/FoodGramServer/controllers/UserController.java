package com.FoodGramServer.FoodGramServer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.FoodGramServer.FoodGramServer.models.*;
import com.FoodGramServer.FoodGramServer.repo.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class UserController {
	@Autowired
<<<<<<< HEAD
	UserRepo userRepo;


	
=======
	UserRepo userRepo;	
>>>>>>> 5fd8f7867be21162b3a824257abc99be0a5d04d5
	
	//returns all users in the User table
	@RequestMapping(method = RequestMethod.GET, path = "/user/all")
	public User[] getComments() { 
<<<<<<< HEAD
		User[] user = userRepo.getAll();
		return user; }

	
	
	
	
=======
		User[] users = userRepo.getAll(); 
		return users;
	}
>>>>>>> 5fd8f7867be21162b3a824257abc99be0a5d04d5
}
