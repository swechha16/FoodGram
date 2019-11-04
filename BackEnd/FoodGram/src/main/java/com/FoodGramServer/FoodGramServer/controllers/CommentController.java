package com.FoodGramServer.FoodGramServer.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.FoodGramServer.FoodGramServer.models.*;
import com.FoodGramServer.FoodGramServer.repo.*;



import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
/**
 * Maps endpoints for the comment class
 * @author Swechha
 *
 */
public class CommentController {
	/**
	 * creates the a reference to the comment repo
	 */
	@Autowired
	CommentRepo commentRepo;
	
	/**
	 * 
	 * @return all the comments in db
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/comment/all")
	public Comment[] getComments() { 
		Comment[] comments = commentRepo.getAll();

		return comments; //returns JSON array of comments
	}
	
	/**
	 * a comment from a user is stored in the database
	 * @param userComment
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/post/comment/users")
	public String postCommentFromUser(@RequestBody String userComment) {
		Comment comments = new Comment();
		comments.setComment(userComment);
		
		commentRepo.save(comments);
		return "Post Added";
	}

	/**
	 * Post a restaurant comment in the database
	 * @param restaurantComment
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/post/comment/restaurant")
	public void postCommentFromRestaurant(@RequestBody String restaurantComment) {
		Comment comments = new Comment();
		comments.setComment(restaurantComment);
		
		commentRepo.save(comments);

		
	}


}
