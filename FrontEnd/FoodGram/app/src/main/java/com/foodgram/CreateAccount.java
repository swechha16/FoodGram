package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;


public class CreateAccount extends AppCompatActivity {


    Button createAccount_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        createAccount_submit = findViewById(R.id.createAccountSubmit);

        createAccount_submit.setOnClickListener(new View.OnClickListener() {
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
