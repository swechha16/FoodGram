package com.FoodGramServer.FoodGramServer.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	public List<Photo> getPhotos() {
		List<Photo> photos = photoRepo.getAll();
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
	public List<Photo> getPostByFoodTagAndPrice(@PathVariable String foodCategory, @PathVariable String priceCategory) {
		List<Photo> photos = photoRepo.getByFoodTagAndPriceTag(foodCategory, priceCategory);
		return photos;
	}	
	
	/**
	 * Gets all the photos from a certain restaurant
	 * @param restaurant
	 * @return photos from a restaurant
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/photo/{restaurant}")
	public List<Photo> findByRestaurant(@PathVariable String restaurant) {
		List<Photo> photos = photoRepo.getByRestaurant(restaurant);
		return photos;
	}
	
	
	/**
	 * post the photos to the database
	 * @param userPhoto
	 */
	@PostMapping(path = "/post/photo")
	public String postPhoto(@RequestBody Photo userPhoto) {
		System.out.println(userPhoto.getCaption());
		photoRepo.save(userPhoto);
		return "{\"OK\"}";

	}

	/**
	 * Posting the image from the user into the image folder on the server
	 * @param file
	 * @return file path
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/post/image")
	public String fileUpload(@RequestParam("file") MultipartFile file) {
		Path path = null;
		if (!file.getOriginalFilename().contains("."))
			return "Filename missin extension";
		String name = UUID.randomUUID().toString() + "." + file.getOriginalFilename().split("\\.")[1];
		try {
			byte[] bytes = file.getBytes();
	        path = Paths.get("/var/html/www/images/" + name);
			Files.write(path, bytes);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "http://coms-309-mg-1.cs.iastate.edu/images/"+name;
	}
}
