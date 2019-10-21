package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    TextView mTextViewResult;
    ImageView profilePic;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
     mQueue = Volley.newRequestQueue(this);

getProfilePosts();



    }


    public void getProfilePosts(){

      String url = "http://10.26.1.154:8080/photo/restr";
        JsonArrayRequest testRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    // JSONArray jsonArray =
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
        String url = "http://192.168.86.26:8080/user/alexi";

        JsonArrayRequest testRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    // JSONArray jsonArray =
                    if(response.length() != 0) {

                        for (int i = 0; i < response.length(); i++) {
                            JSONObject userBio = response.getJSONObject(i);

                            // long id = comment.getInt("id");
                            String caption = userBio.getString("user");
                            String restaurantName = userBio.getString("restaurant");
                            String foodTag = userBio.getString("foodTag");
                            String costTag = userBio.getString("costTag");


                            mTextViewResult.append(caption + "\n" + foodTag + "\n" + costTag + "\n" + restaurantName + "\n\n\n");

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
    }

}
