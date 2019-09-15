package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    Button welcome_login;
    Button welcome_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        welcome_login = findViewById(R.id.loginButton);
        welcome_signin = findViewById(R.id.SignUpButton);
    }

    welcome_login.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v)
        // Code here executes on main thread after user presses button
    });



}
