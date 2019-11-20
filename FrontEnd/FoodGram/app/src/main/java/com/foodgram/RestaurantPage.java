package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RestaurantPage extends AppCompatActivity {

    TextView rTextViewResult;
    TextView restaurantBioTextView;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_page);


        restaurantBioTextView = findViewById(R.id.restaurantBioView);
        rTextViewResult = findViewById(R.id.restaurantPost);

        Button refreshButton = findViewById(R.id.refreshButton);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRestaurantProfilePosts();
                getRestaurantBio();
            }
        });



    }

    public void getRestaurantProfilePosts(){

    }

    public void getRestaurantBio(){

    }


}
