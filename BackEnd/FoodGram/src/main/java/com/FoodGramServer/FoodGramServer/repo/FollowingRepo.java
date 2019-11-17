package com.FoodGramServer.FoodGramServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FoodGramServer.FoodGramServer.models.Photo;

@Repository
public interface FollowingRepo extends JpaRepository<Photo, Long> {

}