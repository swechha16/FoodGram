package com.foodgram;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
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
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

/**
 * The profile page for a user
 */
public class ProfilePage extends AppCompatActivity {
    RequestQueue mQueue;
    RequestQueue mQueue2;

    /**
     * Shows the bio for the user
     */
    TextView userBioTextView;
    /**
     * The username of the user to be displayed
     */
    String userName;

    ImageView profilePic;

    private List<Photo> photoList;
    RecyclerView postsView;
    FeedPageAdapter feedPageAdapter;
    User user = new User();


    /**
     * Creates the Volley and Buttons for refreshing the profile page
     *
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
    //Get logged in user!!
       final Parcelable parcelable = getIntent().getParcelableExtra("LoggedInUser");
        user = Parcels.unwrap(parcelable);






        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent a = new Intent(ProfilePage.this, PersonalFeedPage.class);

                        a.putExtra("LoggedInUser", parcelable);
                        startActivity(a);
                        break;
                    case R.id.action_search:
                        Intent b = new Intent(ProfilePage.this, FilteredFoodFeed.class);
                        b.putExtra("LoggedInUser", parcelable);
                        startActivity(b);
                    case R.id.action_add_post:
                        Intent c = new Intent(ProfilePage.this, PostPhotoPage.class);

                        c.putExtra("LoggedInUser", parcelable);

                        startActivity(c);
                        break;
                    case R.id.action_about:


                    case R.id.id_logout:
                        Intent e = new Intent(ProfilePage.this, HomePage.class);

                        startActivity(e);
                        break;
                }
                return false;
            }
        });


        photoList = new ArrayList<Photo>();
        postsView = findViewById(R.id.profilePagefeedView);

        feedPageAdapter = new FeedPageAdapter(this, photoList);

        postsView.setAdapter(feedPageAdapter);
        postsView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        postsView.setLayoutManager(linearLayoutManager);

        getProfilePosts();
        getBio();

        updatePicture(user.getProfile_pic());

    }

    /**
     * Gets all of a posts from a user and displays them.
     */
    public void getProfilePosts() {

        String url = "http://coms-309-mg-1.cs.iastate.edu:8080/photo/all";
        JsonArrayRequest testRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {

                    if (response.length() != 0) {

                        for (int i = 0; i < response.length(); i++) {
                            JSONObject post = response.getJSONObject(i);
                            System.out.println(post.toString());

                            String tempEmail = post.getJSONObject("user").getString("email");

                            if (tempEmail.equals(user.getEmail())) {
                                String caption = post.getString("caption");
                                String restaurantName = post.getString("restaurant");
                                String foodTag = post.getString("foodTag");
                                String costTag = post.getString("costTag");
                                String picUrl = post.getString("pic");
                                String timeStamp = post.getString("timestamp");
                                long picId = post.getLong("picId");


                                feedPageAdapter.add(new Photo(user, picUrl, caption, foodTag, costTag, restaurantName, timeStamp, picId));

                            }
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


    /**
     * Gets the bio from a user and displays it on the page.
     */

    public void getBio() {

        String url = "http://coms-309-mg-1.cs.iastate.edu:8080/user/" + user.getUsername();

        JsonArrayRequest bioRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    if (response.length() != 0) {

                        for (int i = 0; i < response.length(); i++) {
                            JSONObject userBio = response.getJSONObject(i);

                            String bio = userBio.getString("bio");
                            userName = userBio.getString("username");
                            userBioTextView.setText(bio);


                        }
                    } else {
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

    public void updatePicture(String link) {
        Glide.with(this)
                .load(link)
                .into(profilePic);

    }

}


