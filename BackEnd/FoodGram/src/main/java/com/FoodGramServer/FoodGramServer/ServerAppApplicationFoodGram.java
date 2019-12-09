package com.FoodGramServer.FoodGramServer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.FoodGramServer.FoodGramServer.repo.CommentRepo;
import com.FoodGramServer.FoodGramServer.repo.DatabaseInitializer;
import com.FoodGramServer.FoodGramServer.repo.FollowingRepo;
import com.FoodGramServer.FoodGramServer.repo.PhotoRepo;
import com.FoodGramServer.FoodGramServer.repo.UserRepo;

@SpringBootApplication
public class ServerAppApplicationFoodGram{


	public static void main(String[] args) {
		SpringApplication.run(ServerAppApplicationFoodGram.class, args);
		//System.out.println("Database initialized");
	}

}
