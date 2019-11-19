package com.FoodGramServer.FoodGramServer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.FoodGramServer.FoodGramServer.models.Following;
import com.FoodGramServer.FoodGramServer.repo.FollowingRepo;

@RestController
public class FollowingController {

	@Autowired
	FollowingRepo followingRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/followers/{userNum}")
	public List<Following> getFollowers(@PathVariable int userNum) {
		return followingRepo.getFollowers(userNum); 
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/following/{userNum}")
	public List<Following> getFollowing(@PathVariable int userNum){
		return followingRepo.getFollowing(userNum);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/follow/count/{userNum}")
	public int getFollowerCount(@PathVariable int userNum) {
		return followingRepo.getFollowerCount(userNum);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/following/count/{userNum}")
	public int getFollowingCount(@PathVariable int userNum) {
		return followingRepo.getFollowingCount(userNum);
	}
	
}
