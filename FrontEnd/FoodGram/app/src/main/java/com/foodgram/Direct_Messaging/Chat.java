package com.foodgram.Direct_Messaging;

import com.foodgram.User;

public class Chat {
   private int sender, receiver;

   private String message;


    public Chat(int sender, int receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
