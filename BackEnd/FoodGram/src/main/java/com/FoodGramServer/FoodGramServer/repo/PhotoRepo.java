package com.FoodGramServer.FoodGramServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FoodGramServer.FoodGramServer.models.Photo;

@Repository
public interface PhotoRepo extends JpaRepository<Photo, Long>{
    @Query(value = "SELECT * FROM photo", nativeQuery = true)
	public Photo[] getAll();
    
    
<<<<<<< HEAD
    @Query(value = "SELECT * FROM photo p WHERE p.food_tag = ?1", nativeQuery = true)
   	public Photo[] findPhotoByFoodTag(String food_tag);
=======
    @Query(value = "SELECT * FROM photo Where food_tag = ?1", nativeQuery = true)
   	public Photo[] getByFoodTag(String foodTag);
>>>>>>> 628c92fcb50cbf81b6c17d4ebcf06cea089d3aae
    
   
} 
