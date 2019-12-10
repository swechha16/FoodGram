package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

/**
 * Creates a new user account
 * @author vtorres
 */
public class CreateAccount extends AppCompatActivity {


    Button createAccount_submit;

    /**
     * This sets up the page and creates the button functionality.
     * @param savedInstanceState
     */
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

    /**
     * Takes the user to a new page (HomePageWithFeedPost) and starts the activity.
     * @param v
     */
    public void onButtonClick(View v){
Intent myIntent = new Intent(this, PersonalFeedPage.class);


    startActivity(myIntent);

}



}
