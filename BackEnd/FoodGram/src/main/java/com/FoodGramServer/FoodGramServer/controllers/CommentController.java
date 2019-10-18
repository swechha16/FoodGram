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

public class CommentController {

	@Autowired
	CommentRepo commentRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/comment/all")
	public Comment[] getComments() { 
		Comment[] comments = commentRepo.getAll();
	
		return comments; //returns JSON array of comments
	}

	// I have no idea if any of this works - swechha 


	@RequestMapping(method = RequestMethod.POST, path = "/post/comment/users")
	public Comment postCommentFromUser(@RequestBody Comment comment) {
		
//		Comment comment = new Comment();
//		comment.setComment(userComment);
	

		commentRepo.save(comment);
		
		return comment;
	}

	/*
	 * Post for restaurant comment
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/post/comment/restaurant")
	public void postCommentFromRestaurant(@RequestBody String restaurantComment) {
		Comment comment = new Comment();
		comment.setComment(restaurantComment);
	
		
		commentRepo.save(comment); 
		

	}

	

}
