package com.FoodGramServer.FoodGramServer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.FoodGramServer.FoodGramServer.models.Photo;
import com.FoodGramServer.FoodGramServer.models.User;
import com.FoodGramServer.FoodGramServer.repo.UserRepo;

@RestController
public class UserController {
	@Autowired

	UserRepo userRepo;

	// returns all users in the User table

	@RequestMapping(method = RequestMethod.GET, path = "/user/all")
	public User[] getComments() {

		User[] user = userRepo.getAll();
		return user;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/user/{username}")
	public User[] getUserByUser(@PathVariable String username) {

		User[] user = userRepo.getByUsername(username);
		return user;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/post/user")
	public void createNewUser(@RequestBody User newUser) {
		userRepo.save(newUser);

	}
	

	

}
