package com.FoodGramServer.FoodGramServer.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FoodGramServer.FoodGramServer.models.Following;
import com.FoodGramServer.FoodGramServer.models.Photo;
import com.FoodGramServer.FoodGramServer.models.User;

@Repository
public interface FollowingRepo extends JpaRepository<Following, Long> {

	/**
	 * Gets the number of followers a {user} has
	 * @param user
	 * @return num of users
	 */
	@Query(value="SELECT count(*) FROM following WHERE follow_id = ?1", nativeQuery=true)
	public int getFollowerCount(int user);

	/**
	 * Gets the number of user a {user} is following 
	 * @param user
	 * @return num of users being followed
	 */
	@Query(value="SELECT count(*) FROM following WHERE follower_id = ?1", nativeQuery=true)  
		public int getFollowingCount(int user);
	

	/**
	 * Displays all the followers of a certain {user}
	 * @param user
	 * @return list of followers
	 */
	@Query(value = "SELECT * FROM following WHERE follow_id = ?1", nativeQuery=true)
	public List<Following> getFollowers(int user);

	/**
	 * Display all the user a {user} is following
	 * @param user
	 * @return list of users
	 */
	@Query(value = "SELECT * FROM following WHERE follower_id = ?1", nativeQuery=true)
	public List<Following> getFollowing(int user);
	
	@Query(value = "SELECT EXISTS (SELECT * FROM following WHERE follower_id = ?1 AND follow_id = ?2);", nativeQuery=true)
	public int getExist(long u1, long u2);

	


}