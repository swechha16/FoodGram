package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
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

public class ProfilePage extends AppCompatActivity {
    RequestQueue mQueue;
    RequestQueue mQueue2;

    TextView mTextViewResult;
    TextView userBioTextView;
    String userName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
     mQueue = Volley.newRequestQueue(this);
     mQueue2 = Volley.newRequestQueue(this);

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


    public void getProfilePosts(){

      String url = "http://10.29.178.67:8080/photo/all";
        JsonArrayRequest testRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                    mTextViewResult.setText("");
                try {

                    // JSONArray jsonArray =
                    if(response.length() != 0) {

                        for (int i = 0; i < response.length(); i++) {
                            JSONObject post = response.getJSONObject(i);

                          //  mTextViewResult.append(post.getJSONObject("userId").getString("username"));
                            //mTextViewResult.append("\nUserName assigned: " + userName + "\n");

                            if(post.getJSONObject("userId").getString("username").equals(userName)) {

                                //mTextViewResult.append("They are equal\n");
                                // long id = comment.getInt("id");
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


    public void getBio(){
        String url = "http://10.29.178.67:8080/user/rony";

        JsonArrayRequest bioRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    // JSONArray jsonArray =
                    if(response.length() != 0) {

                        for (int i = 0; i < response.length(); i++) {
                            JSONObject userBio = response.getJSONObject(i);

                            // long id = comment.getInt("id");
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

}
