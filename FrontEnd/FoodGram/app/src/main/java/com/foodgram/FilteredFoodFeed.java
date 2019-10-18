package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FilteredFoodFeed extends AppCompatActivity {
    private TextView mTextViewResult;
    private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtered_food_feed);
    }


    public void getFilteredFeed(){

        String url = "http://coms-309-mg-1.cs.iastate.edu:3306/comment/all";



        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("photos");
                            mTextViewResult.setText("");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject comment = jsonArray.getJSONObject(i);

                                long id = comment.getInt("id");
                                String caption = comment.getString("caption");
                                String foodTag = comment.getString("food_tag");
                                String costTag = comment.getString("cost_tag");


                                mTextViewResult.append(id + "\t" + caption + "" + foodTag + "\t" + costTag + "\n\n");

                            }


                        } catch (JSONException e) {
                            mTextViewResult.setText("JSON EXCEPTION");
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                mTextViewResult.setText("Error");
                error.printStackTrace();
            }
        });

        mQueue.add(request);


    }
}
