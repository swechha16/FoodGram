package com.FoodGramServer.FoodGramServer.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	
	
	
    @RequestMapping("/comment/get/all")
    public String getComments(@RequestBody String string, @RequestHeader(value = "Authorization")) {
    	long id = -1;
    //	JSONObject obj = new JSONObject(string);
   //     long user = Long.parseLong(obj.get("id").toString());
        commentRepo.findAll();
        
    	
    	
    	
    	
    	return string;
    	
    }
	
	
    @RequestMapping("/comment/add")
    public String addComment(@RequestBody String string, @RequestHeader(value = "Authorization") Optional<String> header) {
    	
    	
    	
    	
    	
    	
    	return string; 
    
    }
  
	
	
	
	
	
	
	
}
 
