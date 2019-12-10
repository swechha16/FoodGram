package com.FoodGramServer.FoodGramServer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.FoodGramServer.FoodGramServer.models.Following;
import com.FoodGramServer.FoodGramServer.models.Photo;
import com.FoodGramServer.FoodGramServer.repo.FollowingRepo;
/**
 * ENDPOINTS
 * GET   /followers/{userNum} returns list of {userNum} followers
 * GET   /following/{userNum} returns list users that {userNum} is following
 * GET   /follow/count/{userNum} returns number of followers for that user
 * GET	 /following/count/{userNum} returns number of users {userNum} is following
 * POST  /add/follower adds new following relation to the database
 * @author Alexis Cordts
 *
 */
@RestController
public class FollowingController {

	/**
	 * Links Repository
	 */
	@Autowired
	FollowingRepo followingRepo;

	/**
	 * GET   /followers/{userNum} returns list of {userNum} followers
	 * @param userNum
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/followers/{userNum}")
	public List<Following> getFollowers(@PathVariable int userNum) {
		return followingRepo.getFollowers(userNum); 
	}
	
	/**
	 * GET   /following/{userNum} returns list users that {userNum} is following
	 * @param userNum
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/following/{userNum}")
	public List<Following> getFollowing(@PathVariable int userNum){
		return followingRepo.getFollowing(userNum);
	}
	
	/**
	 * GET   /follow/count/{userNum} returns number of followers for that user
	 * @param userNum
	 * @return number of followers for that user
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/follow/count/{userNum}")
	public int getFollowerCount(@PathVariable int userNum) {
		return followingRepo.getFollowerCount(userNum);
	}

	/**
	 * GET   /follower/count/{userNum} returns number of users {userNum} is following
	 * @param userNum
	 * @return number of user {userNum} is following
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/following/count/{userNum}")
	public int getFollowingCount(@PathVariable int userNum) {
		return followingRepo.getFollowingCount(userNum);
	}
	
	
	/**
	 * POST  /add/follower adds new following relation to the database
	 * @param follow
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/add/follower")
	public void addFollowers(@RequestBody Following follow) {
		if(followingRepo.getExist(follow.getFollower().getUserId(), follow.getUser().getUserId()) == 0) {
			followingRepo.save(follow);
		}
	}

}
