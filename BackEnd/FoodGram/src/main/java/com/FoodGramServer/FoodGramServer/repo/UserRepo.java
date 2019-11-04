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
	
    @Query(value = "SELECT * FROM user", nativeQuery = true)
	public List<User> getAll();
    
    @Query(value = "SELECT * FROM user Where username = ?1", nativeQuery = true)
	public List<User> getByUsername(String findUsername);
    
}
