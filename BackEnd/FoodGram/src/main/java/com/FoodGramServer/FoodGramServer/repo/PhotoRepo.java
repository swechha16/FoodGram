package com.FoodGramServer.FoodGramServer.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FoodGramServer.FoodGramServer.models.Photo;


@Repository
public interface PhotoRepo extends JpaRepository<Photo, Long>{
    @Query(value = "SELECT * FROM photo", nativeQuery = true)
	public List<Photo> getAll();

    @Query(value = "SELECT * FROM photo Where food_tag = ?1 AND cost_tag = ?2", nativeQuery = true)
   	public List<Photo> getByFoodTagAndPriceTag(String foodTag, String priceTag);
    
    @Query(value = "SELECT * FROM photo WHERE restaurant = ?1", nativeQuery = true)
    public List<Photo> getByRestaurant(String restaurant);
    
    @Query(value = "SELECT * FROM photo WHERE cost_tag = ?1", nativeQuery = true)
	public List<Photo> getByPriceTag(String priceTag);



    
    
} 
