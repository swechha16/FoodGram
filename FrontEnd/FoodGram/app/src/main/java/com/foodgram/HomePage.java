package com.foodgram;

import android.content.Intent;
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

        welcome_login.setOnClickListener( new View.OnClickListener(){
            public void onClick (View v){
                login_page(v);
            }
        });

        welcome_signin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                create_account_page(v);
            }
        });
    }

    public void login_page(View v){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void create_account_page(View v){
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }
}
