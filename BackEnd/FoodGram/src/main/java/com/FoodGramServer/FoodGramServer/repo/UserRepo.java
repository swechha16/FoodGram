package com.FoodGramServer.FoodGramServer.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.FoodGramServer.FoodGramServer.models.User;

public interface UserRepo extends JpaRepository<User, Long>{

	// the database
    @Query(value = "SELECT * FROM User", nativeQuery = true)
	public User[] getAll();
    
    

}
