package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.foodgram.R;

import org.json.JSONException;
import org.json.JSONObject;

public class Other_Users_Profile extends AppCompatActivity {
    Button follow;
    TextView followCount;
    TextView followingCount;

    RequestQueue followQueue;
    RequestQueue followingQueue;
    RequestQueue followUserQueue;

    User otherProfile = new User(2, "ronnie", "amcordts@iastate.edu", "user", "pass1234");
    User loggedIn = new User(3, "sweaty", "sweaty@iastate.edu", "user", "pass1234");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other__users__profile);

        followQueue = Volley.newRequestQueue(this);
        followingQueue = Volley.newRequestQueue(this);
        followUserQueue = Volley.newRequestQueue(this);


        follow = findViewById(R.id.Follow_btn);
        followCount = findViewById(R.id.FollowerDisplay);
        followingCount = findViewById(R.id.FollowingDisplay);

        updateFollowCount();
        updateFollowingCount();

    }

    public void updateFollowCount() {
        String url = "http://coms-309-mg-1.cs.iastate.edu:8080/following/count/"+otherProfile.getUser_id();
        //String url = "http://10.31.31.154:8080/following/count/"+otherProfile.getUser_id();


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String count = response;
                        followCount.setText(count);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        followQueue.add(stringRequest);
    }

    public void updateFollowingCount(){
        String url = "http://coms-309-mg-1.cs.iastate.edu:8080/follow/count/"+otherProfile.getUser_id();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String count = response;
                        followingCount.setText(count);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        followingQueue.add(stringRequest);
    }

    public void addFollower(){
        String url = "http://coms-309-mg-1.cs.iastate.edu:8080/add/follower";


        final JSONObject follow = new JSONObject();
        final JSONObject u1 = new JSONObject();
        final JSONObject u2 = new JSONObject();

        try {
            u1.put("userId", loggedIn.getUser_id());
            u2.put("userId", otherProfile.getUser_id());

            follow.put("follower", u1);
            follow.put("user", u2);

            Log.d("Response", follow.toString());

        }
        catch (JSONException e){
            e.printStackTrace();
        }

        /**
         * Receives response from controller and displays response on Logcat
         */
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, url, follow, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Log.d("Response", response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error.Response", error.toString());

            }

        }) ;


        followUserQueue.add(objectRequest);

    }
}
