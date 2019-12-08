package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.foodgram.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Other_Users_Profile extends AppCompatActivity {
        TextView Following, Followers, otherUserBio;
        Button followBtn, refreshBtn, message_user_btn;
        ImageView otherUser_pic;
        String userName;
    private List<Photo> photoList;
    RequestQueue mQueue;


    FeedPageAdapter feedPageAdapter;
        RecyclerView postsView;
    User user = new User( 1, "Sweaty", "sweaty@iastate.edu", "user", "pass1234");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other__users__profile);
        mQueue = Volley.newRequestQueue(this);

        Following = findViewById(R.id.Other_Following);
        Followers = findViewById(R.id.OtherUser_Followers);
        otherUserBio = findViewById(R.id.Other_userBioTextView);
        followBtn = findViewById(R.id.Follow_btn);
        message_user_btn = findViewById(R.id.message_user_btn);
        otherUser_pic = findViewById(R.id.OtherUser_profilePic);


        getBio();

        photoList = new ArrayList<Photo>();
        postsView = findViewById(R.id.other_profile_posts);

        feedPageAdapter = new FeedPageAdapter(this, photoList);

        postsView.setAdapter(feedPageAdapter);
        postsView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        postsView.setLayoutManager(linearLayoutManager);



        user.setProfile_pic("https://scontent.fdsm1-1.fna.fbcdn.net/v/t1.0-9/41793156_249057839002346_8937745557640708096_n.jpg?_nc_cat=108&_nc_ohc=BViWIqxmozEAQl1oSq1O5FyPQPGzmQ0ZuyfUrl_lqJ_cLDsDGI_Bz7F8g&_nc_ht=scontent.fdsm1-1.fna&oh=dd2d28d0c055ed87e07db9e564ab9faa&oe=5E6B3834");
        getBio();

        updatePicture(user.getProfile_pic());
        getProfilePosts();






    }

    /**
     * Follow the user for this page
     */
    public void followUser(){

    }


        public void getBio(){
            String url = "http://coms-309-mg-1.cs.iastate.edu:8080/user/alexi";

            JsonArrayRequest bioRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    try {

                        if(response.length() != 0) {

                            for (int i = 0; i < response.length(); i++) {
                                JSONObject userBio = response.getJSONObject(i);

                                String bio = userBio.getString("bio");
                                userName = userBio.getString("username");



                               otherUserBio.setText("\t\tUser Bio \n\t\t-------------\nUser Name : " + userName + "\nBio: "  + bio );

                            }
                        }else{
                            otherUserBio.append("No profile");
                        }


                    } catch (JSONException e) {
                       otherUserBio.setText("JSON EXCEPTION");
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                        System.out.println(error.getMessage());
                }
            }
            );

        }

    /**
     * Gets all of a posts from a user and displays them.
     */
    public void getProfilePosts(){

        String url = "http://coms-309-mg-1.cs.iastate.edu:8080/photo/all";
        JsonArrayRequest testRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
//                mTextViewResult.setText("");
                try {

                    if(response.length() != 0) {

                        for (int i = 0; i < response.length(); i++) {
                            JSONObject post = response.getJSONObject(i);



//                            if(post.getJSONObject("userId").getString("username").equals(userName)) {


                            String caption = post.getString("caption");
                            String restaurantName = post.getString("restaurant");
                            String foodTag = post.getString("foodTag");
                            String costTag = post.getString("costTag");
                            user = new User(1, "Sweaty", "sweaty@iastate.edu", "user", "pass1234");
                            user.setProfile_pic("https://scontent.fdsm1-1.fna.fbcdn.net/v/t1.0-9/41793156_249057839002346_8937745557640708096_n.jpg?_nc_cat=108&_nc_ohc=BViWIqxmozEAQl1oSq1O5FyPQPGzmQ0ZuyfUrl_lqJ_cLDsDGI_Bz7F8g&_nc_ht=scontent.fdsm1-1.fna&oh=dd2d28d0c055ed87e07db9e564ab9faa&oe=5E6B3834");

                            feedPageAdapter.add(new Photo(user, "http://coms-309-mg-1.cs.iastate.edu/images/pizza.jpg", "Delicious Pizza", "pizza", "$", "papa johns", "12:30", 2));
                            feedPageAdapter.add(new Photo(user, "http://coms-309-mg-1.cs.iastate.edu/images/pizza.jpg", "Delicious Pizza", "pizza", "$", "papa johns", "12:30", 2));


//                            }


                        }
                    }


                } catch (JSONException e) {
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


    public void updatePicture(String link){
        Glide.with(this)
                .load(link)
                .into(otherUser_pic);

    }


    }











