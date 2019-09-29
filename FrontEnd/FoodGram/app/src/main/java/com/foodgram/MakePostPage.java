package com.foodgram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MakePostPage extends AppCompatActivity {

    private Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_post_page);

        signOut = (Button) findViewById(R.id.signOut_post);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcome_page();
            }
        });
    }

    public void welcome_page(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

}
