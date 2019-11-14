package com.foodgram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    private Button FeedHomePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FeedHomePage = (Button) findViewById(R.id.tryLoginButton);
        FeedHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Feed_Page();
            }
        });
    }

    public void Feed_Page(){
        Intent intent = new Intent(this, HomePageWithFeedPost.class);
        startActivity(intent);
    }
}
