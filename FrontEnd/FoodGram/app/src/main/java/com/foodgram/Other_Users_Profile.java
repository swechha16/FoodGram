package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.foodgram.R;

public class Other_Users_Profile extends AppCompatActivity {
    Button follow;
    TextView followCount;
    TextView followingCount;

    RequestQueue followQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other__users__profile);

        followQueue = Volley.newRequestQueue(this);

        follow = findViewById(R.id.Follow_btn);
        followCount = findViewById(R.id.FollowerDisplay);
        followingCount = findViewById(R.id.FollowingDisplay);

    }

    public void updateFollowCount() {
        String url = "http://coms-309-mg-1.cs.iastate.edu:8080/";

    }
}
