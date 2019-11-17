package com.FoodGramServer.FoodGramServer.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FoodGramServer.FoodGramServer.models.Photo;
import com.FoodGramServer.FoodGramServer.models.User;

@Repository
public interface FollowingRepo extends JpaRepository<Photo, Long> {

	// counts followers	
	// counts following
	
	// SELECT distinct fu.user_user_id, f.user_id FROM following_user fu, following f WHERE fu.user_following_following_id = f.following_id;
	// displays all followers
	
	@Query(value = "SELECT distinct user_user_id FROM following_user WHERE user_following_following_id = ?1", nativeQuery=true)
	public List<User> getFollowers(int user);
	// displays following
	// adds follower

	@Query(value = "SELECT * user_user_id FROM following_user", nativeQuery = true)
	public List<User> getAllFollowers();

}