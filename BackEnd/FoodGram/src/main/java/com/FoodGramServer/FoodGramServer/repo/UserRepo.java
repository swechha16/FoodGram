package com.FoodGramServer.FoodGramServer.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FoodGramServer.FoodGramServer.models.User;



/** 
 * JPA repository for User
 *
 * @author Swechha Ghimire and Alexis Cordts
 *
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	//we're gonna have to query the FRICK out of this once we figure
	// the database
	/**
	 * gets all the users from the database
	 * @return array of users
	 */
    @Query(value = "SELECT * FROM user", nativeQuery = true)
	public List<User> getAll();
    
    /**
     * returns the users with a certain username
     * @param findUsername
     * @return array of users
     */
    @Query(value = "SELECT * FROM user Where username = ?1", nativeQuery = true)
	public List<User> getByUsername(String findUsername);
    
    @Query(value = "Select caption From user where restaurant = ?1", nativeQuery = true)
	public User[] getCaptionByRestaurant(String restaurant);

}
