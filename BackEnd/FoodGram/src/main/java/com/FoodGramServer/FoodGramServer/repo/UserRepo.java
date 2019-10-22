package com.FoodGramServer.FoodGramServer.repo;

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
    @Query(value = "SELECT * FROM user", nativeQuery = true)
	public User[] getAll();
    
    @Query(value = "SELECT * FROM user Where username = ?1", nativeQuery = true)
	public User[] getByUsername(String findUsername);

    
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM user WHERE username = ?1", nativeQuery = true)
	public void deleteUserByUsername(String userName);
    
   
}
