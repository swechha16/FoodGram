package com.FoodGramServer.FoodGramServer.controllers;

import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping(method = RequestMethod.GET, path = "/comment/all")
    public String getComments() { // Comment[]
    	Comment[] comments = commentRepo.getAll();	
    	
    	
    	//return comments[0].toString();
    
    	String ret = "{\"comments\":[";
    	    	
    	// iterates through all of the comments except the last one in the array
    	for(int i = 0; i < comments.length-1; i++) {
    		ret = 	ret + "{\"id\":\""+comments[i].getId()+"\",\"comment\":\""+comments[i].getComment()+"\"},";
    	}
    	ret = ret+ "{\"id\":\""+comments[comments.length-1].getId()+"\",\"comment\":\""+comments[comments.length-1].getComment()+"\"}]}";
    	//return "{\"comments\":[{\"id\":1,\"comment\":\"This was awesome\"}]}";
		// returns a string of all the comments in a format to be parsed
    	return ret;
    }
	
}
 
