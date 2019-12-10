package com.foodgram;


import android.support.design.widget.BottomNavigationView;


import android.content.Intent;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.booleanThat;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.ColorInt;

import android.support.v4.content.res.ResourcesCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

public class SwechhaMockTest {



//    @Mock
// PostPhotoPage page;
//    @InjectMocks
//    BottomNavigationView bot;
//
//
//    @Mock
// FilteredFoodFeed fff ;
//
//
//
//
//    private static final int[] MENU_CONTENT_ITEM_IDS = {
//            R.id.action_about, R.id.action_message, R.id.action_add_post,R.id.action_search,
//            R.id.navigation_home
//    };
//
//
//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//        bot = (BottomNavigationView) page.findViewById(R.id.nav_view);
//    }
//
//
//
//    @Test
//
//    public void testBasics() {
//
//        final Menu menu = bot.getMenu();
//        assertNotNull("Menu should not be null", menu);
//        assertEquals("Should have matching number of items", MENU_CONTENT_ITEM_IDS.length, menu.size());
//        for (int i = 0; i < MENU_CONTENT_ITEM_IDS.length; i++) {
//            final MenuItem currItem = menu.getItem(i);
//            assertEquals("ID for Item #" + i, MENU_CONTENT_ITEM_IDS[i], currItem.getItemId());
//        }
//    }
//
//
//
//    @Test
//
//    public void testSetSelectedItemId() {
//        BottomNavigationView.OnNavigationItemSelectedListener mockedListener =
//                mock(BottomNavigationView.OnNavigationItemSelectedListener.class);
//        bot.setOnNavigationItemSelectedListener(mockedListener);
//        when(mockedListener.onNavigationItemSelected(any(MenuItem.class))).thenReturn(true);
//
//        bot.setSelectedItemId(R.id.action_message);
//
//        verify(mockedListener, times(1))
//                .onNavigationItemSelected(bot.getMenu().findItem(R.id.action_message));
//
//        assertTrue(bot.getMenu().findItem(R.id.action_message).isChecked());
//
//    }
//
//
//    @Test
//
//    public void testSettingMenuItemVisibility() throws Throwable {
//        final MenuItem homeMenuItem = bot.getMenu().findItem(R.id.navigation_home);
//        assertTrue(homeMenuItem.isVisible());
//        homeMenuItem.setVisible(false);
//        assertFalse(homeMenuItem.isVisible());
//
//        final MenuItem destinationMenuItem =
//                bot.getMenu().findItem(R.id.navigation_home);
//        assertFalse(destinationMenuItem.isVisible());
//        destinationMenuItem.setVisible(true);
//        assertTrue(destinationMenuItem.isVisible());
//    }


}
