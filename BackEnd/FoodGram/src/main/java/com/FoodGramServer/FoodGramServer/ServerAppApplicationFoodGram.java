package com.FoodGramServer.FoodGramServer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServerAppApplicationFoodGram{


	public static void main(String[] args) {
		SpringApplication.run(ServerAppApplicationFoodGram.class, args);



	}

}
