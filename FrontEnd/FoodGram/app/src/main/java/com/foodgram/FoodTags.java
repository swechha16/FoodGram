package com.foodgram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FoodTags extends AppCompatActivity {

    Button foodTag_SubmitChinese;
    Button foodTag_SubmitItalian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_tags);
        foodTag_SubmitChinese = findViewById(R.id.ChineseFoodButton);
        foodTag_SubmitItalian = findViewById(R.id.ItalianFoodButton);


        foodTag_SubmitItalian.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onButtonClick(v);
            }
        });

        foodTag_SubmitChinese.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
    }


    public void onButtonClick(View v){
        Intent myIntent = new Intent(this,   PriceRange.class);
        startActivity(myIntent);

    }
}
