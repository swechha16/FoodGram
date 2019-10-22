package com.foodgram;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageWithFeedPost extends AppCompatActivity {
    Button feed_move;
    Button make_post_move;
    Button find_food_move;
    Button profile_page;
    Button  home_page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_with_feed_post);
       feed_move = findViewById(R.id.clickToFeedButton);
       make_post_move = findViewById(R.id.clickToPostButton);
       find_food_move = findViewById(R.id.clickToFindFood);
       profile_page = findViewById(R.id.userProfileButton);
        home_page = findViewById(R.id.home);

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

    public void feed_page(View v){
        Intent intent = new Intent(this, PersonalFeedPage.class);
        startActivity(intent);
    }

    public void choose_post_page(View v){
        Intent intent = new Intent(this, ChoosePost.class);
        startActivity(intent);
    }

    public void find_food_page(View v){
        Intent intent = new Intent(this, FilteredFoodFeed.class);
        startActivity(intent);
    }

    public void profile_page(View v){
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }

    public void home_page(View v){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}
