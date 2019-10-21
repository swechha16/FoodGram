package com.FoodGramServer.FoodGramServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FoodGramServer.FoodGramServer.models.Photo;

@Repository
public interface PhotoRepo extends JpaRepository<Photo, Long>{
    @Query(value = "SELECT * FROM photo", nativeQuery = true)
	public Photo[] getAll();
    

    @Query(value = "SELECT * FROM photo Where food_tag = ?1 AND cost_tag = ?2", nativeQuery = true)
   	public Photo[] getByFoodTagAndPriceTag(String foodTag, String priceTag);
    
    @Query(value = "SELECT * FROM photo WHERE restaurant = ?1", nativeQuery = true)
    public Photo[] getByRestaurant(String restaurant);


  
   
} 
