package tests;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.bridge.Message;
import org.junit.Before;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.FoodGramServer.FoodGramServer.models.Photo;
import com.FoodGramServer.FoodGramServer.models.User;
import com.FoodGramServer.FoodGramServer.repo.MessageRepo;
import com.FoodGramServer.FoodGramServer.repo.PhotoRepo;
import com.FoodGramServer.FoodGramServer.repo.UserRepo;

class SwechhaTest {


	

	@Mock
	UserRepo userRepo; 
	@InjectMocks
	User userService;
	
	
	@Mock 
	MessageRepo messageRepo; 
	
	@InjectMocks 
	Message message; 
	

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
    public void testUserRepository(){
        User user = new User();
        user.setAccountType("User");
        user.setUsername("User");
        user.setEmail("test@gmail.com");
        user.setFullName("Test");
        user.setLocationCity("Ames");
        user.setLocationState("Iowa");
        user.setPassword("pass");
        user.setPhoneNo("51515151555");
        user.setUserId(0);
        
     assertEquals("User", user.getAccountType());
     assertEquals("User", user.getUsername());

      
;
    }
	// handling null not returning null 
	
	@Test
	public void getUser() {
		when(userRepo.getByUsername("suraj"));

		assertEquals("suraj", userRepo.getByUsername("suraj"));

	}


	
	
	
	@Test
	public void getAllUsersTest() {
		List<User> list = new ArrayList<User>();
		User acctOne = new User();
		User acctTwo = new User();
		User acctThree = new User();

		list.add(acctOne);
		list.add(acctTwo);
		list.add(acctThree);

		
		assertEquals(3, list.size());
		
	
	}
	
//	
//	@Test
//	public void seeMessage() {
//		Message mess = new Message(1,"hey",rightNow,u1, u2); 
//		Message mess2 = new Message(2,"hello",rightNow,u1, u2); 
//
//		messageRepo.save(mess);
//		messageRepo.save(mess2); 
//		
//		
//	
//		assertNotEquals(mess, mess2);
//		
//	
//	}
//	
//	@Test
//    public void testMessageRepository(){
//       Message mess = new Message(); 
//        String var = mess.getMessage("hello!!"); 
//     assertNotEquals("hello",var);
//   
//
//      
//;
//    }


}
