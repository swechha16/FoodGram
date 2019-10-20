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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FilteredFoodFeed extends AppCompatActivity {
    private TextView mTextViewResult;
    private RequestQueue mQueue;

    //If the int is 0 it will grab all,  1: italian 2 : chinese 3: indian
    private int foodType = 0;
    /**
     * price tag if 0: give them cheap, 1 : moderate, 2: expensive
     */
    private int priceTag = 0;



    private String url = "http://coms-309-mg-1.cs.iastate.edu";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtered_food_feed);


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

    }



    public void getFilteredFeed(){

//        url = "http://10.26.15.174:8080/indian/$";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            System.out.println("onResponse");
                            JSONArray jsonArray = response.getJSONArray("photos");
                            mTextViewResult.setText("");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject comment = jsonArray.getJSONObject(i);

                               // long id = comment.getInt("id");
                                String caption = comment.getString("caption");
                                String foodTag = comment.getString("foodTag");
                                String costTag = comment.getString("costTag");
                                String restaurantName = comment.getString("restaurant");



                                mTextViewResult.append(caption + "\n" + foodTag + "\n" + costTag + "\n" + restaurantName +"\n\n\n");

                            }


                        } catch (JSONException e) {
                            mTextViewResult.setText("JSON EXCEPTION");
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                mTextViewResult.setText("error");
                error.printStackTrace();
            }
        });

        mQueue.add(request);


    }

    public void updateUrl(int foodType){

        if(foodType == 0){
            url = "http://coms-309-mg-1.cs.iastate.edu/photos/all";
        }else if(foodType == 1){
            url = "http://coms-309-mg-1.cs.iastate.edu/photos/italian";
        }else if(foodType ==2 ){
            url = "http://coms-309-mg-1.cs.iastate.edu/photos/chinese";
        }else if(foodType == 3){
            url = "http://coms-309-mg-1.cs.iastate.edu/photos/indian";
        }else{
            url = "http://coms-309-mg-1.cs.iastate.edu/photos/all";
        }




    }

    public void addPriceTag(int priceTag){

        updateUrl(foodType);
        if(priceTag == 1) {
            url += "/$";
        }else if(priceTag == 2){
            url += "/$$";
        }else if(priceTag == 3){
            url += "/$$$";
        }else {
            url += "$";
        }

    }


}
