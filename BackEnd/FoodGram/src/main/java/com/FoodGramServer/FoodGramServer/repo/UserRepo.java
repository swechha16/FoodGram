package com.FoodGramServer.FoodGramServer.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FoodGramServer.FoodGramServer.models.Comment;
import com.FoodGramServer.FoodGramServer.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
    @Query(value = "SELECT * FROM User", nativeQuery = true)
	public User[] getAll();
    
}
