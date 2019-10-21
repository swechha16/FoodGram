package tests;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.FoodGramServer.FoodGramServer.models.Photo;
import com.FoodGramServer.FoodGramServer.models.User;
import com.FoodGramServer.FoodGramServer.repo.PhotoRepo;
import com.FoodGramServer.FoodGramServer.repo.UserRepo;

class SwechhaTest {


	
	@Mock
	UserRepo userRepo; 
	@InjectMocks
	User userService;

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
        when(userRepo.getByUsername("pass")).thenReturn(null);

      

    }
	
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

		
		assertEquals(3, list);
	
	}


}
