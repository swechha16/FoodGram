package com.foodgram;


import android.support.design.widget.BottomNavigationView;


import android.content.Intent;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


import org.junit.Before;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SwechhaMockTest {



    @Mock
 PostPhotoPage page;
    @InjectMocks
    BottomNavigationView bot;


    @Mock
 FilteredFoodFeed fff ;

    @InjectMocks
    BottomNavigationView bot2;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCaseRepository(){
if(bot.getSelectedItemId() ==  R.id.navigation_home) {
    assertEquals(bot.getSelectedItemId(), R.id.navigation_home);
}

    }
    // handling null not returning null

    @Test
    public void get() {



    }








}
