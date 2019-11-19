package com.FoodGramServer.FoodGramServer.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.FoodGramServer.FoodGramServer.models.Following;
import com.FoodGramServer.FoodGramServer.models.Photo;
import com.FoodGramServer.FoodGramServer.models.User;

@Component
public class DatabaseInitializer implements CommandLineRunner
{
	@Autowired
	private FollowingRepo followingRepo;
	
	@Autowired
	private CommentRepo commentRepo; 
	
	@Autowired
	private PhotoRepo photoRepo; 
	
	@Autowired
	private UserRepo userRepo;
	
	public DatabaseInitializer(FollowingRepo followingRepo, CommentRepo commentRepo, PhotoRepo photoRepo, UserRepo userRepo)
	{
		this.followingRepo = followingRepo;
		this.commentRepo = commentRepo;
		this.photoRepo = photoRepo;
		this.userRepo = userRepo;
	}
	
	@Override
	public void run(String... args) throws Exception
	{
		this.followingRepo.deleteAll();
		this.commentRepo.deleteAll();
		this.photoRepo.deleteAll();
		this.userRepo.deleteAll();
		
		try
		{
			User u1 = new User(1, "user", "My name is Alexis", "amcordts@iastate.edu", "Alexis Cordts", "Ames", "IA", "pass1234", "5639408430", "url", "alexi");
			User u2 = new User(2, "user", "I sweat", "sweaty@iastate.edu", "Sweaty Ghimire", "Ames", "IA", "pass1234", "911", "url", "sweaty");
			User u3 = new User(3, "user", "Taki Taki -Selena Gomez", "Ronnie@iastate.edu", "Ronnie Torres", "Ames", "IA", "pass1234", "5159998888", "url", "Ronnie");
			
			Photo p1 = new Photo(1, "Jeff pizza is trash", "$", "Italian", "url", "Jeff's Pizza", u1);
			Photo p2 = new Photo(2, "Indian Palace is the best place to eat in Ames", "$$", "Indian", "url", "Indian Palace", u1);
			Photo p3 = new Photo(3, "Fast and goof Food", "$$", "Chinese", "url", "Wok n Roll", u2);
			Photo p4 = new Photo(4, "The West hyvee chinese is trash", "$", "Chinese", "url", "Hyvee", u2);
			Photo p5 = new Photo(5, "Their breadsticks are fire", "$", "Italian", "url", "Fazolis",  u3);
			
			Following f1 = new Following(1,u1,u2);
			Following f2 = new Following(2,u2,u1);
			Following f3 = new Following(3,u1,u3);
			Following f4 = new Following(4,u3,u2);
					
			userRepo.save(u1);
			userRepo.save(u2);
			userRepo.save(u3);
			
			photoRepo.save(p1);
			photoRepo.save(p2);
			photoRepo.save(p3);
			photoRepo.save(p4);
			photoRepo.save(p5);

			followingRepo.save(f1);
			followingRepo.save(f2);
			followingRepo.save(f3);
			followingRepo.save(f4);
			
			System.out.println("Database has been initialized");	
		}
		catch(Exception cve)
		{
			System.out.println("Database has not been initialized yeet");
		}
	}
	
}
