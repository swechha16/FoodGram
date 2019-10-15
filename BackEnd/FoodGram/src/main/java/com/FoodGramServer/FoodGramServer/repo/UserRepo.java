package com.FoodGramServer.FoodGramServer.repo;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.lang.*;



import com.FoodGramServer.FoodGramServer.models.Comment;
import com.FoodGramServer.FoodGramServer.models.User;




/**
 * JPA repository for User
 *
 * @author Swechha Ghimire and Alexis Cordts
 *
 */
@Repository
<<<<<<< HEAD
public interface UserRepo extends JpaRepository<User, Long> {
	
	
	//we're gonna have to query the FRICK out of this once we figure
	// the database
    @Query(value = "SELECT * FROM User", nativeQuery = true)
	public User[] getAll();
    
    
	
=======
public interface UserRepo extends JpaRepository<User, Long>{
    @Query(value = "SELECT * FROM User", nativeQuery = true)
	public User[] getAll();
    
>>>>>>> c24c99f882a586fa8f7dc4ebd3b440b5962d784b
}
