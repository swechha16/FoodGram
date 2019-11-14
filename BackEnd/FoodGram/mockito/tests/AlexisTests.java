package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.FoodGramServer.FoodGramServer.models.Photo;
import com.FoodGramServer.FoodGramServer.models.User;
import com.FoodGramServer.FoodGramServer.repo.PhotoRepo;

public class AlexisTests {
	
	@Mock
	PhotoRepo photoRepo; 
	@InjectMocks
	Photo photoService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testUserConstructor() {
		Photo photo1 = new Photo();
		User user1 = new User();
		photo1.setCaption("");
		photo1.setCostTag("$");
		photo1.setFoodTag("Mexican");
		//photo1.setPic("");
		photo1.setRestaurant("El Azteca");
//		photo1.setUserId(user1);
		
		assertEquals("$", photo1.getCostTag());
		assertEquals("El Azteca", photo1.getRestaurant());
		
	}

}
