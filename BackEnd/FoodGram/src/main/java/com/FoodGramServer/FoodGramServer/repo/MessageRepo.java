package com.FoodGramServer.FoodGramServer.repo;

import com.FoodGramServer.FoodGramServer.models.Message;
import com.FoodGramServer.FoodGramServer.models.Photo;
import com.FoodGramServer.FoodGramServer.models.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MessageRepo extends JpaRepository<Message, Long> {
    //working on creating relation between users and messages
    //get
    //users are one to one
    @Query(value = "SELECT * FROM message", nativeQuery = true)
    public List<Message> getAll();
    //query all messages between user1 and user 2
    
    @Query(value = "SELECT user1, user2 FROM message", nativeQuery = true)
    public List<Message> getTwoUsersFromMessage(User user1, User user2);
    
    

 
    
  
    // insert username1  and 2, messages and timestamp

}
