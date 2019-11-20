package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RestaurantPage extends AppCompatActivity {
   RequestQueue rQueue;
    TextView rTextViewResult;
    TextView restaurantBioTextView;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_page);


        restaurantBioTextView = findViewById(R.id.restaurantBioView);
        rTextViewResult = findViewById(R.id.restaurantPost);

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



    }

//    public void getRestaurantProfilePosts(){
//
//    }
//
    public void getRestaurantBio(){
        String url = "http://10.31.25.50:8080/user/McDonalds";
        JsonArrayRequest bioRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    if(response.length() != 0) {

                        for (int i = 0; i < response.length(); i++) {
                            JSONObject userBio = response.getJSONObject(i);

                            String bio = userBio.getString("bio");
                            username = userBio.getString("username");



                            restaurantBioTextView.setText("\t\tRestaurant Bio \n\t\t-------------\nRestaurant Name : " + username + "\nBio: "  + bio );

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

