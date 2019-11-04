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

@RestController
public class UserController {
	@Autowired

	UserRepo userRepo;

	// returns all users in the User table

	@RequestMapping(method = RequestMethod.GET, path = "/user/all")
	public List<User> getComments() {
		return userRepo.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/user/{username}")
	public List<User> getUserByUser(@PathVariable String username) {

		return userRepo.getByUsername(username);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/post/user")
	public void createNewUser(@RequestBody User newUser) {
		userRepo.save(newUser);
	}
	
	
	@GetMapping("/user/{uid}/photos")
	public List<Photo> getPhotosForUser(@PathVariable("uid") long uid) {
		User user = userRepo.findById(uid).get();
//		System.out.println(user);
		
		return user.getPhotoPosts();
	}
	

}
