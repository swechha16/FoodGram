package com.FoodGramServer.FoodGramServer.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.FoodGramServer.FoodGramServer.models.Photo;
import com.FoodGramServer.FoodGramServer.repo.PhotoRepo;

@RestController
public class PhotoController {
	@Autowired
	PhotoRepo photoRepo;
	
	//returns all the photos in the Photo table
	@RequestMapping(method = RequestMethod.GET, path = "/photo/all")
	public Photo[] getPhotos() {
		Photo[] photos = photoRepo.getAll();
		return photos;
	}
	
	/**
	 * This method will return a list of our "comments" within photos
	 * that is based on the food type within our database
	 * Types rn: Italian, Chinese, Indian
	 * we want everything in the photo database by specifically queried by tags 
	 * @param foodTag
	 * @return
	 */
	
	@RequestMapping(method = RequestMethod.GET, path = "/photo/{food_tag}")
	public Photo[] getCommentsByFoodTag(@PathVariable String food_tag) {
		Photo[] photos = photoRepo.findPhotoByFoodTag(food_tag);
		return photos;
	}	
}
