package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Intent;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.net.Uri;


public class RestaurantPage extends AppCompatActivity {
   RequestQueue rQueue;
    TextView rTextViewResult;
    TextView restaurantBioTextView;
    String username;
    Button web;
    String restuarantUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_page);


        restaurantBioTextView = findViewById(R.id.restaurantBioView);
        rTextViewResult = findViewById(R.id.restaurantPost);
        web =  findViewById(R.id.showWebsite);



        rQueue = Volley.newRequestQueue(this);
        Button refreshButton = findViewById(R.id.refreshRestaurantButton);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             System.out.println("we out here");
//                getRestaurantProfilePosts();
               getRestaurantBio();
            }
        });






        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("we are really out here");

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(restuarantUrl));
                    startActivity(intent);

            }


        });


    }



    public void getRestaurantProfilePosts(){

        String url = "http://10.31.24.213:8080/photo/all";
        JsonArrayRequest testRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                rTextViewResult.setText("");
                try {

                    if(response.length() != 0) {

                        for (int i = 0; i < response.length(); i++) {
                            JSONObject post = response.getJSONObject(i);



                            if(post.getJSONObject("userId").getString("username").equals(username)) {


                                String caption = post.getString("caption");
                                String restaurantName = post.getString("restaurant");
                                String foodTag = post.getString("foodTag");
                                String costTag = post.getString("costTag");


                                rTextViewResult.append(caption + "\n" + foodTag + "\n" + costTag + "\n" + restaurantName + "\n\n\n");
                            }
                        }
                    }else{
                        rTextViewResult.append("No posts");
                    }


                } catch (JSONException e) {
                    rTextViewResult.setText("JSON EXCEPTION");
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );


        rQueue.add(testRequest);





    }

    public void getRestaurantBio(){

        String url = "http://10.31.24.213:8080/user/bk";
        JsonArrayRequest bioRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    if(response.length() != 0) {

                        for (int i = 0; i < response.length(); i++) {
                            JSONObject userBio = response.getJSONObject(i);

                            String bio = userBio.getString("bio");
                            username = userBio.getString("username");
                            String email = userBio.getString("email");
                          //  String phone = userBio.getString("phone_no");

                            restuarantUrl =  userBio.getString("url");
                            restaurantBioTextView.setText("\t\tRestaurant Bio \n\t\t-------------\nRestaurant Name : " + username + "\nBio: "  + bio +"\nEmail: " + email);



                        }
                    }else{
                        restaurantBioTextView.append("No profile");
                    }


                } catch (JSONException e) {
                   restaurantBioTextView.setText("JSON EXCEPTION");
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );

        rQueue.add(bioRequest);
    }








}

