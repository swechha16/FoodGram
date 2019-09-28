package com.FoodGramServer.FoodGramServer.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.FoodGramServer.FoodGramServer.models.*;
import com.FoodGramServer.FoodGramServer.repo.*;



import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CommentController {



@Autowired
	CommentRepo commentRepo; 
	
	
	//Possible edge cases:
		// comments queries null
	//Notes:
		// I am fairly certain there is an easier way to do this instead of sending long strings
    @RequestMapping(method = RequestMethod.POST, path = "/comment/get/all")
    public String getComments() {
    	String ret = "{";
    	
    	Comment[] comments = commentRepo.getAllComments();
    	// iterates through all of the comments except the last one in the array
    	for(int i = 0; i < comments.length -1; i++) {
    		ret = 	ret + "\"comment" + i + "\": {\"comment\":\""
    				+ comments[i].getComment()
    				+ "\"},";
    	}
    	// adds the last comment in the array and the closing bracket
		ret = 	ret + "\"comment" + (comments.length - 1) + "\": {\"comment\":\""
				+ comments[comments.length-1].getComment()
				+ "\"}}";
		
		// returns a string of all the comments in a format to be parsed
    	return ret.toString();
    }
	
	
    @RequestMapping("/comment/add")
    public String addComment(@RequestBody String string) {
    	
    	return string; 
    }
	
}
 
