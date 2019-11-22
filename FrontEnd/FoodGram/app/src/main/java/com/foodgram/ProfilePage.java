package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * The profile page for a user
 */
public class ProfilePage extends AppCompatActivity {
    RequestQueue mQueue;
    RequestQueue mQueue2;
    /**
     * Shows the users posts
     */
    TextView mTextViewResult;
    /**
     * Shows the bio for the user
     */
    TextView userBioTextView;
    /**
     * The username of the user to be displayed
     */
    String userName;

    ImageView profilePic;






    /**
     * Creates the Volley and Buttons for refreshing the profile page
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        mQueue = Volley.newRequestQueue(this);
        mQueue2 = Volley.newRequestQueue(this);
        profilePic = findViewById(R.id.profilePic);

        userBioTextView = findViewById(R.id.userBioTextView);
        mTextViewResult = findViewById(R.id.userPostsTextView);

        Button refresh = findViewById(R.id.refreshButton);


        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getBio();
                getProfilePosts();
            }
        });





    }

    /**
     * Gets all of a posts from a user and displays them.
     */
    public void getProfilePosts(){

        String url = "http://10.31.27.207:8080/photo/all";
        JsonArrayRequest testRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                mTextViewResult.setText("");
                try {

                    if(response.length() != 0) {

                        for (int i = 0; i < response.length(); i++) {
                            JSONObject post = response.getJSONObject(i);


                                    if(true){
//                            if(post.getJSONObject("userId").getString("username").equals(userName)) {


                                String caption = post.getString("caption");
                                String restaurantName = post.getString("restaurant");
                                String foodTag = post.getString("foodTag");
                                String costTag = post.getString("costTag");


                                mTextViewResult.append(caption + "\n" + foodTag + "\n" + costTag + "\n" + restaurantName + "\n\n\n");
                            }
                        }
                    }else{
                        mTextViewResult.append("No posts");
                    }


                } catch (JSONException e) {
                    mTextViewResult.setText("JSON EXCEPTION");
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );


        mQueue.add(testRequest);
    }

    /**
     * Gets the bio from a user and displays it on the page.
     */
    public void getBio(){
        String url = "http://10.31.27.207:8080/user/alexi";

        JsonArrayRequest bioRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    if(response.length() != 0) {

                        for (int i = 0; i < response.length(); i++) {
                            JSONObject userBio = response.getJSONObject(i);

                            String bio = userBio.getString("bio");
                            userName = userBio.getString("username");



                            userBioTextView.setText("\t\tUser Bio \n\t\t-------------\nUser Name : " + userName + "\nBio: "  + bio );

                        }
                    }else{
                        userBioTextView.append("No profile");
                    }


                } catch (JSONException e) {
                    userBioTextView.setText("JSON EXCEPTION");
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );

        mQueue.add(bioRequest);
    }

    public void updatePicture(){
        Glide.with(this)
                .load("https://cdn0.tnwcdn.com/wp-content/blogs.dir/1/files/2018/02/google-pacman-796x419.jpg")
                .into(profilePic);

    }

}

