package com.FoodGramServer.FoodGramServer.repo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.FoodGramServer.FoodGramServer.models.Following;
import com.FoodGramServer.FoodGramServer.models.Message;
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
	
	@Autowired
	private MessageRepo messageRepo; 
	
	public DatabaseInitializer(FollowingRepo followingRepo, CommentRepo commentRepo, PhotoRepo photoRepo, UserRepo userRepo, MessageRepo messageRepo)
	{
		this.followingRepo = followingRepo;
		this.commentRepo = commentRepo;
		this.photoRepo = photoRepo;
		this.userRepo = userRepo;
		this.messageRepo = messageRepo; 
	}
	
	@Override
	public void run(String... args) throws Exception
	{
		this.followingRepo.deleteAll();
		this.commentRepo.deleteAll();
		this.photoRepo.deleteAll();
		this.userRepo.deleteAll();
		this.messageRepo.deleteAll();
		
		try
		{
			 LocalDateTime rightNow = LocalDateTime.now();
<<<<<<< HEAD
			User u1 = new User(1, "user", "My name is Alexis", "amcordts@iastate.edu", "Alexis Cordts", "Ames", "IA", "pass1234", "5639408430", "https://scontent-dfw5-2.xx.fbcdn.net/v/t1.0-9/29694394_776603022543974_2417560041001972344_n.jpg?_nc_cat=104&_nc_ohc=D3Wt6y48E7UAQkkD-15INBn029ph8GbM3GDEV-4NirTSF2phPSU7lRdcw&_nc_ht=scontent-dfw5-2.xx&oh=ae2c42f7af196f06437afbb1ae940895&oe=5E7358E8", "alexi", "url");
			User u2 = new User(2, "user", "I sweat", "sweaty@iastate.edu", "Sweaty Ghimire", "Ames", "IA", "pass1234", "911", "https://scontent-dfw5-2.xx.fbcdn.net/v/t1.0-9/14463219_1475337695816065_2816561733442178454_n.jpg?_nc_cat=103&_nc_ohc=iQhzGC5EaroAQmt1TodFEh0nt-QN1VztB8fthWLHn5UtGj2SbUepUt-Dg&_nc_ht=scontent-dfw5-2.xx&oh=2a4a083daacfc050d0dff656bc856021&oe=5E77A2B1", "sweaty", "url");
			User u3 = new User(3, "user", "Taki Taki -Selena Gomez", "Ronnie@iastate.edu", "Ronnie Torres", "Ames", "IA", "pass1234", "5159998888", "https://scontent-dfw5-2.xx.fbcdn.net/v/t1.0-9/41793156_249057839002346_8937745557640708096_n.jpg?_nc_cat=108&_nc_ohc=uPZuU4T166EAQke5gW8cEkSJjKPFU8CHJ9FFk-WmpUlwUFkitbaUiCYaw&_nc_ht=scontent-dfw5-2.xx&oh=f10dffba57ac2814d321ee69465d3e24&oe=5E6B3834", "Ronnie", "url");
			
			User  u4 = new User(4, "restaurant", "McDonalds is amazing", "mcdong@mcdong.com", "McDonalds", "Ames", "Iowa", "mcmc", "url",  "5157078976", "mcdong", "https://www.mcdonalds.com");

			User  u5 = new User(5, "restaurant", "Burger KING WERE AWESOME", "bk@bk.com", "Burger King", "Ames", "Iowa", "burg", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Burger_King_Big_King_XXL_Menu.jpg/640px-Burger_King_Big_King_XXL_Menu.jpg",  "5157078976", "bk", "https://mobile.bk.com/"); 
			Photo p1 = new Photo(1, "Jeff pizza is trash", "$", "Italian", "https://static.wixstatic.com/media/fd3bc4_f551ac3d01b94150bef37069c58ca8cd~mv2_d_4000_3000_s_4_2.jpg/v1/fill/w_640,h_592,al_c,q_85,usm_0.66_1.00_0.01/fd3bc4_f551ac3d01b94150bef37069c58ca8cd~mv2_d_4000_3000_s_4_2.webp", "Jeff's Pizza", u1);
			Photo p2 = new Photo(2, "Indian Palace is the best place to eat in Ames", "$$", "Indian", "https://media-cdn.tripadvisor.com/media/photo-s/05/1f/fb/b0/indian-palace.jpg", "Indian Palace", u1);
=======
			User u1 = new User(1, "user", "My name is Alexis", "amcordts@iastate.edu", "Alexis Cordts", "Ames", "IA", "pass1234", "5639408430", "url", "alexi", "url");
			User u2 = new User(2, "user", "I sweat", "sweaty@iastate.edu", "Sweaty Ghimire", "Ames", "IA", "pass1234", "911", "url", "sweaty", "url");
			User u3 = new User(3, "user", "Taki Taki -Selena Gomez", "Ronnie@iastate.edu", "Ronnie Torres", "Ames", "IA", "pass1234", "5159998888", "url", "Ronnie", "url");
			User  u4 = new User(4, "restaurant", "McDonalds is amazing", "mcdong@mcdong.com", "McDonalds", "Ames", "Iowa", "mcmc", "url",  "5157078976", "mcdong", "https://www.mcdonalds.com");

			User  u5 = new User(5, "restaurant", "Burger KING WERE AWESOME", "bk@bk.com", "Burger King", "Ames", "Iowa", "burg", "url",  "5157078976", "bk", "https://mobile.bk.com/"); 
			Photo p1 = new Photo(1, "Jeff pizza is trash", "$", "Italian", "url", "Jeff's Pizza", u1);

			Photo p2 = new Photo(2, "Indian Palace is the best place to eat in Ames", "$$", "Indian", "url", "Indian Palace", u1);
>>>>>>> 6fa6a8a2e5a7b015a49e70d68922a80450ae9ff6
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
			userRepo.save(u4);
			userRepo.save(u5);
			
			Message m1 = new Message(1,"hey",rightNow,u1, u2); 
					
			
			
			
			photoRepo.save(p1);
			photoRepo.save(p2);
			photoRepo.save(p3);
			photoRepo.save(p4);
			photoRepo.save(p5);

			followingRepo.save(f1);
			followingRepo.save(f2);
			followingRepo.save(f3);
			followingRepo.save(f4);
			
			messageRepo.save(m1); 
			
			System.out.println("Database has been initialized");	
		}
		catch(Exception cve)
		{
			System.out.println("Database has not been initialized yeet");
		}
	}
	
}
