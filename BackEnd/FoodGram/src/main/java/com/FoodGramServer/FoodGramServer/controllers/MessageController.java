package com.FoodGramServer.FoodGramServer.controllers;

import com.FoodGramServer.FoodGramServer.models.Message;
import com.FoodGramServer.FoodGramServer.models.Photo;
import com.FoodGramServer.FoodGramServer.models.User;
import com.FoodGramServer.FoodGramServer.repo.MessageRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MessageController {
    @Autowired
    MessageRepo messageRepo;


    @RequestMapping(method = RequestMethod.POST, path = "/websocket/post/{message}")
    public void postWebSocketChat(@PathVariable Message message) {
    	messageRepo.save(message); 

//message repo save (message) 


    }
    @RequestMapping(method = RequestMethod.GET, path = "/websocket/get")
    public List<Message> getWebSocketChat() {
        List<Message> mess = messageRepo.getAll();
        return mess;
    }

}
