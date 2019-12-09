package com.foodgram;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Allows a user to search from multiple different types of food and price ranges in their area.
 * @author Vtorres
 */
public class FilteredFoodFeed extends AppCompatActivity {
    private TextView mTextViewResult;
    private RequestQueue mQueue;

    /**
     *If the int is 0 it will grab all,  1: italian 2 : chinese 3: indian
     */
    private int foodType = 0;
    /**
     * price tag if 0: give them cheap, 1 : moderate, 2: expensive
     */
    private int priceTag = 0;



    private String url = "http://coms-309-mg-1.cs.iastate.edu";

    /**
     * Creates the buttons for the activity page and
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtered_food_feed);
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = findViewById(R.id.nav_view);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_view);


        mTextViewResult = findViewById(R.id.textViewResults);
        mQueue = Volley.newRequestQueue(this);




        Button italian = findViewById(R.id.ItalianButton);
        italian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodType = 1;
            }
        });
        Button chinese = findViewById(R.id.ChineseButton);
        chinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodType = 2;
            }
        });
        Button indian = findViewById(R.id.IndianButton);
        indian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodType =3;
            }
        });

        Button cheap = findViewById(R.id.cheapButton);
        cheap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                priceTag = 1;

            }
        });
        Button moderate = findViewById(R.id.moderatePrice);
        moderate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                priceTag = 2;
            }
        });
        Button expensive = findViewById(R.id.expensiveButton);
        expensive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                priceTag =3;
            }
        });

        Button getFiltered = findViewById(R.id.getFilteredFood);

        getFiltered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(priceTag!= 0 && foodType != 0){
                    addPriceTag(priceTag);
                    getFilteredFeed();

                }
            }
        });


        BottomNavigationView navi = (BottomNavigationView) findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                      Intent a = new Intent(FilteredFoodFeed.this, PersonalFeedPage.class);
                        startActivity(a);
                        break;
                    case R.id.action_search:
                        Intent b = new Intent(FilteredFoodFeed.this, FilteredFoodFeed.class);
                        startActivity(b);
                        break;
                    case R.id.action_add_post:
                        Intent c = new Intent(FilteredFoodFeed.this, PostPhotoPage.class);
                        startActivity(c);
                        break;
                    case R.id.action_about:
                        Intent d = new Intent(FilteredFoodFeed.this, ProfilePage.class);
                        startActivity(d);
                        break;
                    case R.id.id_logout:
                        Intent e = new Intent(FilteredFoodFeed.this, HomePage.class);
                        startActivity(e);
                        break;
                }
                return false;
            }
        });



    }



    /**
     * Updates the url with the food type a user wants
     * At the moment it can only do one food type at a time.
     * @param foodType - The type of food a user wants to search for
     */
    public void updateUrl(int foodType){
        url = "http://10.31.29.6:8080/photo";
        if(foodType == 0){
          url += "/all";
        }else if(foodType == 1){
            url += "/italian";
        }else if(foodType ==2 ){
            url += "/chinese";
        }else if(foodType == 3){
            url += "/indian";
        }else{
            url += "/all";
        }


    }

    /**
     * Searches food by a certain price tag the user wants to stay within.
     * @param priceTag - The price of food a user wants to search "$" , "$$" , or "$$$"
     */
    public void addPriceTag(int priceTag){

        updateUrl(foodType);
        if(priceTag == 1) {
            url += "/$";
        }else if(priceTag == 2){
            url += "/$$";
        }else if(priceTag == 3){
            url += "/$$$";
        }else {
            url += "/$";
        }

    }

    /**
     * This grabs all the data from the JSON using the correct food type and price a user wants to search for.
     */
    public void getFilteredFeed(){

mTextViewResult.setText("");
    //   url = "http://10.26.1.154:8080/photo/all";
        JsonArrayRequest testRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                        mTextViewResult.setText("");
                try {


                    if(response.length() != 0) {

                        for (int i = 0; i < response.length(); i++) {
                            JSONObject comment = response.getJSONObject(i);

                            // long id = comment.getInt("id");
                            String caption = comment.getString("caption");
                            String restaurantName = comment.getString("restaurant");
                            String foodTag = comment.getString("foodTag");
                            String costTag = comment.getString("costTag");


                            mTextViewResult.append(caption + "\n" + foodTag + "\n" + costTag + "\n" + restaurantName + "\n\n\n");

                        }
                    }else{
                        mTextViewResult.append("\nNo posts");
                    }


                } catch (JSONException e) {
                    mTextViewResult.setText("JSON EXCEPTION");
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                if (error instanceof TimeoutError || error instanceof NoConnectionError){
                    mTextViewResult.setText("Timeout Error or No connection error");
                }
                else if(error instanceof AuthFailureError){
                    mTextViewResult.setText("authentication failure error");
                }else if(error instanceof ServerError){
                    mTextViewResult.setText("server error");
                }else if(error instanceof NetworkError){
                    mTextViewResult.setText("network error");
                }else if(error instanceof ParseError) {
                    mTextViewResult.setText("Parse Error");
                }

                mTextViewResult.append("\n\n " + url);

                }
            }
        );

        mQueue.add(testRequest);

    }

    /**
     * For Mockito Test of receiving a price request from a user.
     * @param url - The url to test
     * @param price - the price the user wants to search for
     * @param linkHandler -
     * @return - true if the url works, false if not.
     * @throws JSONException
     */
    public boolean tryRecieving(String url, String price, LinkHandler linkHandler) throws JSONException {

        //Does not work because .getResponse has not been implemented
        if (linkHandler.getLink(url, price).getBoolean("loginSuccess")) {
            return true;
        }

        return false;
    }



}
