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

/**
 * Maps endpoints for the photo class
 * @author Alexis and Swechha
 *
 */
@RestController
public class PhotoController {
	@Autowired
	/**
	 * links the controller to the photorepo
	 */
	PhotoRepo photoRepo;
	
	//returns all the photos in the Photo table
	/**
	 * Gets all the photos in the database
	 * @return all photos
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/photo/all")
	public Photo[] getPhotos() {
		Photo[] photos = photoRepo.getAll();
		return photos;
	}
	
	/**
	 * This method will return a list of our "comments" within photos
	 * that is based on the food type within our database
	 * We want everything in the photo database by specifically queried by tags 
	 * @param foodTag
	 * @return photos with matching price and food
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/photo/{foodCategory}/{priceCategory}")
	public Photo[] getPostByFoodTagAndPrice(@PathVariable String foodCategory, @PathVariable String priceCategory) {
		Photo[] photos = photoRepo.getByFoodTagAndPriceTag(foodCategory, priceCategory); 
		return photos;
	}	
	
	/**
	 * Gets all the photos from a certain restaurant
	 * @param restaurant
	 * @return photos from a restaurant
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/photo/{restaurant}")
	public Photo[] findByRestaurant(@PathVariable String restaurant) {
		Photo[] photos = photoRepo.getByRestaurant(restaurant);
		return photos;
	}
	
	
	/**
	 * post the photos to the database
	 * @param userPhoto
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/post/photo")
	public void postPhoto(@RequestBody Photo userPhoto) {
		photoRepo.save(userPhoto);

	}
	
	
	
}
