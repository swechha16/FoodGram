package com.FoodGramServer.FoodGramServer.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FoodGramServer.FoodGramServer.models.Photo;
/**
 * JPA repository for photos
 * @author alexis and swechha
 *
 */
@Repository
public interface PhotoRepo extends JpaRepository<Photo, Long>{
	/**
	 * Gets all of the photos in the database
	 * @return array of photos
	 */
    @Query(value = "SELECT * FROM photo", nativeQuery = true)
	public List<Photo> getAll();

    /**
     * gets all the photos that match the given foodtags and costags
     * @param foodTag
     * @param priceTag
     * @return array of photos
     */
    @Query(value = "SELECT * FROM photo Where food_tag = ?1 AND cost_tag = ?2", nativeQuery = true)
   	public List<Photo> getByFoodTagAndPriceTag(String foodTag, String priceTag);
    
    /**
     * returns all the photos with a specific restaurant time
     * @param restaurant
     * @return array of photos
     */
    @Query(value = "SELECT * FROM photo WHERE restaurant = ?1", nativeQuery = true)
    public List<Photo> getByRestaurant(String restaurant);
    
    /**
     * gets all the photos that are in a certain price range
     * @param priceTag
     * @return array of photos
     */
    @Query(value = "SELECT * FROM photo WHERE cost_tag = ?1", nativeQuery = true)
	public List<Photo> getByPriceTag(String priceTag);


    @Query(value = "SELECT * FROM photo WHERE username = ?1", nativeQuery = true)
	public List<Photo> getByUser(String user);    
} 
