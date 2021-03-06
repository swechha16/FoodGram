package com.FoodGramServer.FoodGramServer.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.lang.*;



import com.FoodGramServer.FoodGramServer.models.Comment;




/**
 * JPA repository for Accounts
 *
 * @author Swechha Ghimire and Alexis Cordts
 *
 */
@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
	
	
	//we're gonna have to query the FRICK out of this once we figure
	// the database
	/**
	 * gets all the comments
	 * @return array of comments
	 */
    @Query(value = "SELECT * FROM comment", nativeQuery = true)
	public List<Comment> getAll();
    
    @Query(value = "SELECT comment FROM comment WHERE pic_id = ?1", nativeQuery = true)
    public List<Comment> getPicComment(String pic_id);
    
    
	
}


