package com.FoodGramServer.FoodGramServer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.FoodGramServer.FoodGramServer.models.Photo;
import com.FoodGramServer.FoodGramServer.repo.PhotoRepo;

@RestController
public class PhotoController {
	@Autowired
	PhotoRepo photoRepo;
	
	//returns all the photos in the Photo table
	@RequestMapping(method = RequestMethod.GET, path = "photo/all")
	public Photo[] getPhotos() {
		Photo[] photos = photoRepo.getAll();
		return photos;
	}
}
