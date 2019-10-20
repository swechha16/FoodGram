package com.foodgram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageWithFeedPost extends AppCompatActivity {
    Button feed_move;
    Button make_post_move;
    Button find_food_move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_with_feed_post);
       feed_move = findViewById(R.id.clickToFeedButton);
       make_post_move = findViewById(R.id.clickToPostButton);
       find_food_move = findViewById(R.id.clickToFindFood);


        // should move to feed page
        feed_move.setOnClickListener( new View.OnClickListener(){
            public void onClick (View v){
                feed_page(v);
            }
        });

        // should move to make post page
        make_post_move.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                make_post_page(v);
            }
        });

        //should move to find food
        find_food_move.setOnClickListener( new View.OnClickListener(){
            public void onClick (View v){
                find_food_page(v);
            }
        });
    }

    public void feed_page(View v){
        Intent intent = new Intent(this, PersonalFeedPage.class);
        startActivity(intent);
    }

    public void make_post_page(View v){
        Intent intent = new Intent(this, MakePostPage.class);
        startActivity(intent);
    }

    public void find_food_page(View v){
        Intent intent = new Intent(this, FilteredFoodFeed.class);
        startActivity(intent);
    }
}
