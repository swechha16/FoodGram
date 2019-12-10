package com.foodgram;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.renderscript.ScriptGroup;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Pulls the users feed (similar to the Instagram feed page) from recent posts from the users they follow. Will also sign a user out when the sign out button is clicked.
 */
public class PersonalFeedPage extends AppCompatActivity {
    /**
     * Where follower posts will be displayed
     */
    /**
     *
     */
    private RequestQueue mQueue;
    /**
     * When this button is pressed the user will be signed out.
     */
    private List<Photo> photoList;
    RecyclerView feedView;
    FeedPageAdapter feedPageAdapter;
    User loggedInUser = new User();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_feed_page);

        final Parcelable parcelable = getIntent().getParcelableExtra("LoggedInUser");
        loggedInUser = Parcels.unwrap(parcelable);

        mQueue = Volley.newRequestQueue(this);




        photoList = new ArrayList<Photo>();

        feedView = findViewById(R.id.feedPage_recyclerView);
        feedPageAdapter = new FeedPageAdapter(this, photoList);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                switch (item.getItemId()) {
                    case R.id.navigation_home:
//                        Intent a = new Intent(this, PersonalFeedPage.class);
//                        startActivity(a);
                        break;
                    case R.id.action_search:
                        Intent b = new Intent(PersonalFeedPage.this, FilteredFoodFeed.class);
                        b.putExtra("LoggedInUser", parcelable);
                        startActivity(b);
                    case R.id.action_add_post:
                        Intent c = new Intent(PersonalFeedPage.this, PostPhotoPage.class);

                        c.putExtra("LoggedInUser", parcelable);

                        startActivity(c);
                        break;
                    case R.id.action_about:
                        Intent d = new Intent(PersonalFeedPage.this, ProfilePage.class);
                        d.putExtra("LoggedInUser", parcelable);

                        startActivity(d);
                        break;
                    case R.id.id_logout:
                        Intent e = new Intent(PersonalFeedPage.this, HomePage.class);

                        startActivity(e);
                        break;
                }
                return false;
            }
        });

        feedView.setAdapter(feedPageAdapter);
        feedView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        feedView.setLayoutManager(linearLayoutManager);

        getFeed();

    }

    /**
     * Takes the user to the welcome page (signs them off)
     */
    public void welcome_page(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }


    /**
     * Gets the posts from the backend and adds it to the textview for a user to see on screen.
     */
    public void getFeed() {



       String url = "http://coms-309-mg-1.cs.iastate.edu:8080/photo/all";


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                       try {

                           for (int i = 0; i < response.length(); i++) {
                               JSONObject post = response.getJSONObject(i);

                               //Make the user

                                String username = post.getJSONObject("user").getString("username");
                                Long userId = post.getJSONObject("user").getLong("userId");
                                String accountType = post.getJSONObject("user").getString("accountType");
                                String password = post.getJSONObject("user").getString("password");
                                String tempEmail = post.getJSONObject("user").getString("email");
                                String profilePic = post.getJSONObject("user").getString("profilePic");


                                   String caption = post.getString("caption");
                                   String restaurantName = post.getString("restaurant");
                                   String foodTag = post.getString("foodTag");
                                   String costTag = post.getString("costTag");
                                   String picUrl = post.getString("pic");
                                   String timeStamp = post.getString("timestamp");
                                   long picId = post.getLong("picId");

                                   User tempUser = new User(userId, username, tempEmail, accountType, password);
                                    tempUser.setProfile_pic(profilePic);

                                   feedPageAdapter.add(new Photo(tempUser, picUrl, caption, foodTag, costTag, restaurantName, timeStamp, picId));


                           }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();


            }
        });

        mQueue.add(request);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_screen_navigation, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        //handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.action_message:
                startActivity(new Intent(this, DirectMessage.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}





