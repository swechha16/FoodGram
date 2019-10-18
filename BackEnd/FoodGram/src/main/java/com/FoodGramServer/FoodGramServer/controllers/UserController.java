package com.FoodGramServer.FoodGramServer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.FoodGramServer.FoodGramServer.models.User;
import com.FoodGramServer.FoodGramServer.repo.UserRepo;

@RestController
public class UserController {
	@Autowired
	UserRepo userRepo;

	//returns all users in the User table
	@RequestMapping(method = RequestMethod.GET, path = "/user/all")
	public User[] getComments() { 

		User[] user = userRepo.getAll();
		return user; }

	
	}

