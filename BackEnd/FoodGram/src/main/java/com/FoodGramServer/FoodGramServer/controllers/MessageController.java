package com.FoodGramServer.FoodGramServer.controllers;

import com.FoodGramServer.FoodGramServer.models.Message;
import com.FoodGramServer.FoodGramServer.models.Photo;
import com.FoodGramServer.FoodGramServer.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MessageController {
    @Autowired
    MessageRepo messageRepo;


    @RequestMapping(method = RequestMethod.POST, path = "/websocket/post/{photo}")
    public void postWebSocketChat(@PathVariable Message message) {
        messageRepo.save(message);



    }
    @RequestMapping(method = RequestMethod.GET, path = "/websocket/get")
    public Message[] getWebSocketChat(@PathVariable Message message) {
        Message[] mess = messageRepo.getAll();
        return mess;
    }

}
