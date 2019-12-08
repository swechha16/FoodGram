package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.foodgram.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class Other_Users_Profile extends AppCompatActivity {
        TextView Following, Followers, otherUserBio;
        Button followBtn, refreshBtn, message_user_btn;
        ImageView otherUser_pic;
        String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other__users__profile);

        Following = findViewById(R.id.Other_Following);
        Followers = findViewById(R.id.OtherUser_Followers);
        otherUserBio = findViewById(R.id.Other_userBioTextView);
        followBtn = findViewById(R.id.Follow_btn);
//        refreshBtn = findViewById(R.id.Other_User_refreshButton);
        message_user_btn = findViewById(R.id.message_user_btn);
        otherUser_pic = findViewById(R.id.OtherUser_profilePic);

//        refreshBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getBio();
//                System.out.println("Did something");
//            }
//        });
getBio();

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

    }











