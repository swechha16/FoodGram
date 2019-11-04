package com.foodgram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * This class corresponds to the choose post activity, which allows a user to choose between posting with a photo or without.
 * @author Vtorres
 */

public class ChoosePost extends AppCompatActivity {

    private Button stringPost, photoPost, signOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_post);

        stringPost = findViewById(R.id.string_post);
        photoPost = findViewById(R.id.photo_post);

        signOut = (Button) findViewById(R.id.signOut_post);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcome_page();
            }
        });

        stringPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_post_page(v);
            }
        });

        photoPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photo_post_page(v);
            }
        });
    }

    /**
     * This method starts the activity for welcome page
     */
    public void welcome_page() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    /**
     * Opens the make post page for the user.
     * @param v
     */
    public void make_post_page(View v){
        Intent intent = new Intent(this, MakePostPage.class);
        startActivity(intent);
    }

    /**
     * Opens the post photo page for the user.
     * @param v
     */
    public void photo_post_page(View v){
        Intent intent = new Intent(this, PostPhotoPage.class);
        startActivity(intent);
    }

}
