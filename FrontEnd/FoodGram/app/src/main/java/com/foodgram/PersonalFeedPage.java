package com.foodgram;

import android.content.Intent;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
//    String JSON_String;
    /**
     * Where follower posts will be displayed
     */
    private TextView mTextViewResult;
    /**
     *
     */
    private RequestQueue mQueue;
    /**
     * When this button is pressed the user will be signed out.
     */
    private Button signOut;
    private List<Photo> photoList;
    RecyclerView feedView;
    FeedPageAdapter feedPageAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_feed_page);

        signOut = findViewById(R.id.btn_signOut);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcome_page();
            }
        });


        mTextViewResult = findViewById(R.id.tv_ViewComments);
//        Button btn_getFeed = findViewById(R.id.btn_getFeed);

        mQueue = Volley.newRequestQueue(this);




        photoList = new ArrayList<Photo>();

        feedView = findViewById(R.id.feedPage_recyclerView);
        feedPageAdapter = new FeedPageAdapter(this, photoList);




        feedView.setAdapter(feedPageAdapter);
        feedView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        feedView.setLayoutManager(linearLayoutManager);
//        btn_getFeed.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                getFeed();
//            }
//        });

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
//        String url = "http://10.65.23.83:8080/photo/all";


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                       try {

                           mTextViewResult.setText("");
                           for (int i = 0; i < response.length(); i++) {
                               JSONObject photo = response.getJSONObject(i);


                               //Get stuff from the photo

                               System.out.println(photo);
                               User sweaty =  new User( 1, "Sweaty", "sweaty@iastate.edu", "user", "pass1234");
                               sweaty.setProfile_pic("https://cdn0.tnwcdn.com/wp-content/blogs.dir/1/files/2018/02/google-pacman-796x419.jpg");
                               final User send = new User( 1, "Sweaty", "sweaty@iastate.edu", "user", "pass1234");

//                               String picUrl = photo.getString("pic");
                               String picUrl = "http://coms-309-mg-1.cs.iastate.edu/images/pizza.jpg";
                               String caption = photo.getString("caption");
                               String restaurant = photo.getString("restaurant");


//                               User tempUser = new User(photo.getLong(""));

//                               long id = photo.getInt("userId");
//                               String commentC = photo.getString("comment");
                                    feedPageAdapter.add(new Photo(sweaty, "https://scontent.fdsm1-1.fna.fbcdn.net/v/t1.0-9/41793156_249057839002346_8937745557640708096_n.jpg?_nc_cat=108&_nc_ohc=BViWIqxmozEAQl1oSq1O5FyPQPGzmQ0ZuyfUrl_lqJ_cLDsDGI_Bz7F8g&_nc_ht=scontent.fdsm1-1.fna&oh=dd2d28d0c055ed87e07db9e564ab9faa&oe=5E6B3834", "sweaty pic", "none", "$", "none", "12", 1 )) ;
//                               mTextViewResult.append(id + "\t" + commentC + "\n\n");


                                feedPageAdapter.add(new Photo (sweaty, "https://i.ndtvimg.com/i/2016-06/chinese-625_625x350_81466064119.jpg", "It was ok", "chinese", "$", "Le's Restaurant", "12", 3));
                           }


                        } catch (JSONException e) {
                            mTextViewResult.setText("JSON EXCEPTION");
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                mTextViewResult.setText(error.getMessage());
                error.printStackTrace();


            }
        });

        mQueue.add(request);

    }


}

