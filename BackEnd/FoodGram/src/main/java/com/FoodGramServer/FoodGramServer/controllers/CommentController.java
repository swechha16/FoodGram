package com.FoodGramServer.FoodGramServer.controllers;

import org.springframework.web.bind.annotation.PathVariable;
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

	/**
	 * Gets ALL comments stored in the database
	 * @return comment list
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/comment/all")
	public List<Comment> getComments() { 
		return commentRepo.getAll();
	}
	
	/**
	 * returns all the comments based on the picture id
	 * @param picId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/comment/{picId}")
	public List<Comment> getPicComments(@PathVariable String picId){
			return commentRepo.getPicComment(picId);
	}


	/**
	 * Posts a comment on a certain photo
	 * @param comment
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/post/comment")
	public void postCommentFromRestaurant(@RequestBody Comment comment) {
		commentRepo.save(comment);
	}


}
