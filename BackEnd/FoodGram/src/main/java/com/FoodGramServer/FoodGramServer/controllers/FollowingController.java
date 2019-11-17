package com.FoodGramServer.FoodGramServer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.FoodGramServer.FoodGramServer.models.Photo;
import com.FoodGramServer.FoodGramServer.models.User;
import com.FoodGramServer.FoodGramServer.repo.FollowingRepo;

public class FollowingController {

	@Autowired
	FollowingRepo followingRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/followers/{user}")
	public List<User> getFollowers(@PathVariable int user) {
		return followingRepo.getFollowers(user); 
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/followers/all")
	public List<User> getAllFollowers(){
		return followingRepo.getAllFollowers();
	}
	
}
