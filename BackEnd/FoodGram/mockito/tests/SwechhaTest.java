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
	UserRepo repo; 
	@InjectMocks
	User[] userService = repo.getAll();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	public void getUser() {
		when(repo.getByUsername("suraj"));


		assertEquals("suraj", repo.getByUsername("suraj"));

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
