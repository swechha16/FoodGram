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
import org.springframework.http.ResponseEntity;

@RestController

public class CommentController {

	@Autowired
	CommentRepo commentRepo;

	Comment userComment;

	// Possible edge cases:
	// comments queries null
	// Notes:
	// I am fairly certain there is an easier way to do this instead of sending long
	// strings
	@RequestMapping(method = RequestMethod.GET, path = "/comment/all")
	public String getComments() { // Comment[]
		Comment[] comments = commentRepo.getAll();

		// return comments[0].toString();

		String ret = "{\"comments\":[";

		// iterates through all of the comments except the last one in the array
		for (int i = 0; i < comments.length - 1; i++) {
			ret = ret + "{\"id\":\"" + comments[i].getId() + "\",\"comment\":\"" + comments[i].getComment() + "\"},";
		}
		ret = ret + "{\"id\":\"" + comments[comments.length - 1].getId() + "\",\"comment\":\""
				+ comments[comments.length - 1].getComment() + "\"}]}";
		// return "{\"comments\":[{\"id\":1,\"comment\":\"This was awesome\"}]}";
		// returns a string of all the comments in a format to be parsed
		return ret;
	}

	// I have no idea if any of this works - swechha 

	@RequestMapping(method = RequestMethod.POST, path = "/comment/post//user/all")
	public Comment postCommentFromUser(@RequestBody Comment userComment) {
		Comment comment = new Comment();
		comment.setComment(comment.getComment());
		comment.setTimestamp(comment.getTimestamp());

		sqlInsert(userComment);

		return comment;

	}

	/*
	 * Post for restaurant comment
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/comment/post/all")
	public Comment postCommentFromRestaurant(@RequestBody Comment restaurantComment) {
		Comment comment = new Comment();
		comment.setComment(comment.getComment());
		comment.setTimestamp(comment.getTimestamp());

		sqlInsert(restaurantComment);

		return comment;

	}
/*
 * This is the method that will insert (hopefully) a
 * comment with the comment attributes into the database 
 * 
 * 
 */
	public void sqlInsert(Comment comment) {

		try {
			String url = "jdbc:mysql://coms-309-mg-1.cs.iastate.edu:3306/FoodGramDB"; // change to our url?
			Connection conn = DriverManager.getConnection(url, "", "");
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO comment VALUES ('" + comment.getId() + "', '" + comment + "', "
					+ comment.getTimestamp() + ");");

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

	}

}
