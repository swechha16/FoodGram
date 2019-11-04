package com.FoodGramServer.FoodGramServer.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.FoodGramServer.FoodGramServer.models.Comment;
import com.FoodGramServer.FoodGramServer.models.Photo;
import com.FoodGramServer.FoodGramServer.repo.PhotoRepo;


@RestController
public class PhotoController {
	@Autowired
	PhotoRepo photoRepo;
	
	//returns all the photos in the Photo table
	@RequestMapping(method = RequestMethod.GET, path = "/photo/all")
	public List<Photo> getPhotos() {
		return photoRepo.getAll();
	}
	
	/**
	 * This method will return a list of our "comments" within photos
	 * that is based on the food type within our database
	 * Types rn: Italian, Chinese, Indian
	 * we want everything in the photo database by specifically queried by tags 
	 * @param foodTag
	 * @return 
	 */
	
	@RequestMapping(method = RequestMethod.GET, path = "/photo/{foodCategory}/{priceCategory}")
	public List<Photo> getPostByFoodTagAndPrice(@PathVariable String foodCategory, @PathVariable String priceCategory) {
		return photoRepo.getByFoodTagAndPriceTag(foodCategory, priceCategory); 
	
	}	
	
	@RequestMapping(method = RequestMethod.GET, path = "/photo/{restaurant}")
	public List<Photo> findByRestaurant(@PathVariable String restaurant) {
		return photoRepo.getByRestaurant(restaurant);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/post/photo")
	public void postPhoto(@RequestBody Photo userPhoto) {
		photoRepo.save(userPhoto);
	}
	
	
	
}
