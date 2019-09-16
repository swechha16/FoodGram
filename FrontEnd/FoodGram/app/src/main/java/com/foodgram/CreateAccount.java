package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;


public class CreateAccount extends AppCompatActivity {


    Button b1 =  (Button)findViewById(R.id.createAccount);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }


public void onButtonClick(View v){
Intent myIntent = new Intent(getBaseContext(),   PriceRange.class);
    startActivity(myIntent);

}



}
