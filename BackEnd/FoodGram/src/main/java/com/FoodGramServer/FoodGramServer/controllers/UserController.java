package com.FoodGramServer.FoodGramServer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.FoodGramServer.FoodGramServer.models.Photo;
import com.FoodGramServer.FoodGramServer.models.User;
import com.FoodGramServer.FoodGramServer.repo.UserRepo;

/**
 * Maps endpoints for the user class
 * @author Alexis and Swechha
 *
 */
@RestController
public class UserController {
	@Autowired
	/**
	 * links the userrepo to the user controller
	 */
	UserRepo userRepo;

	// returns all users in the User table
	/**
	 * gets all the user in the database
	 * @return all users
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/user/all")
	public List<User> getComments() {
		List<User> user = userRepo.getAll();
		return user;
	}

	/**
	 * gets all the user with a certain username
	 * @param username
	 * @return user array
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/user/{username}")
	public List<User> getUserByUser(@PathVariable String username) {

		List<User> user = userRepo.getByUsername(username);
		return user;
	}

	/**
	 * Adds a user into database
	 * @param newUser
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/post/user")
	public void createNewUser(@RequestBody User newUser) {
		userRepo.save(newUser);

	}	
	/**
	 * gets the restaurant user based off of restaurant 
	 * @param username
	 * @return user array
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/user/{restaurant}")
	public List<User> getCaptionByRestaurant(@PathVariable String restaurant) {
		List<User> user = userRepo.getByUsername(restaurant);
		return user;
	}


}
