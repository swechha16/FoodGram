package com.foodgram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Shows the user some options to go to after logging in.
 * @author Vtorres
 */
public class HomePageWithFeedPost extends AppCompatActivity {
    Button feed_move;
    Button make_post_move;
    Button find_food_move;
    Button profile_page;
    Button  home_page;
    Button Direct_Message_Page;
    Button restaurant_Page;


    Button other_profile_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_with_feed_post);
       feed_move = findViewById(R.id.clickToFeedButton);
       make_post_move = findViewById(R.id.clickToPostButton);
       find_food_move = findViewById(R.id.clickToFindFood);
       profile_page = findViewById(R.id.userProfileButton);
        home_page = findViewById(R.id.home);
        Direct_Message_Page = findViewById(R.id.MessagesButton);
                restaurant_Page = findViewById(R.id.restaurantBtn);


        restaurant_Page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restaurant_move(view);
            }
        });
        other_profile_button = findViewById(R.id.other_user_profile_btn);

other_profile_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        other_profile_page(view);
    }
});
        Direct_Message_Page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                direct_message_page(view);
            }
        });
        // should move to feed page
        feed_move.setOnClickListener( new View.OnClickListener(){
            public void onClick (View v){
                feed_page(v);
            }
        });

        // should move to make post page
        make_post_move.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                choose_post_page(v);
            }
        });

        //should move to find food
        find_food_move.setOnClickListener( new View.OnClickListener(){
            public void onClick (View v){
                find_food_page(v);
            }
        });

        profile_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile_page(view);
            }
        });

      home_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home_page(view);
            }
        });


    }

    /**
     * Opens up the filtered food feed page
     * @param v
     */
    public void feed_page(View v){
        Intent intent = new Intent(this, PersonalFeedPage.class);
        startActivity(intent);
    }

    /**
     * Opens up the choose to post photo or comment page
     * @param v
     */
    public void choose_post_page(View v){
        Intent intent = new Intent(this, ChoosePost.class);
        startActivity(intent);
    }

    /**
     * Opens up the search for food page
     * @param v
     */
    public void find_food_page(View v){
        Intent intent = new Intent(this, FilteredFoodFeed.class);
        startActivity(intent);
    }

    /**
     * Opens up the current logged in users profile page
     * @param v
     */
    public void profile_page(View v){
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }

    /**
     * Takes a user back to the home page.
     * @param v
     */
    public void home_page(View v){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void direct_message_page(View v){
        Intent intent = new Intent(this, DirectMessage.class);
        startActivity(intent);
    }

    public void restaurant_move(View v) {
        Intent intent = new Intent(this, RestaurantPage.class);
        startActivity(intent);
    }
    public void other_profile_page(View view){
        Intent intent = new Intent (this, Other_Users_Profile.class);
        startActivity(intent);
    }
}
