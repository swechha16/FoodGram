package com.foodgram;

import android.content.Intent;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
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
//    private TextView mTextViewResult;
    /**
     *
     */
    private RequestQueue mQueue;
    /**
     * When this button is pressed the user will be signed out.
     */
//    private Button signOut;
    private List<Photo> photoList;
    RecyclerView feedView;
    FeedPageAdapter feedPageAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_feed_page);

//        signOut = findViewById(R.id.btn_signOut);
//        signOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                welcome_page();
//            }
//        });


//        mTextViewResult = findViewById(R.id.tv_ViewComments);
//        Button btn_getFeed = findViewById(R.id.btn_getFeed);

        mQueue = Volley.newRequestQueue(this);




        photoList = new ArrayList<Photo>();

        feedView = findViewById(R.id.feedPage_recyclerView);
        feedPageAdapter = new FeedPageAdapter(this, photoList);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
//                        Intent a = new Intent(this, PersonalFeedPage.class);
//                        startActivity(a);
                        break;
                    case R.id.action_search:
                        Intent b = new Intent(PersonalFeedPage.this, FilteredFoodFeed.class);
                        startActivity(b);
                        break;
                    case R.id.action_add_post:
                        Intent c = new Intent(PersonalFeedPage.this, PostPhotoPage.class);
                        startActivity(c);
                        break;
                    case R.id.action_about:
                        Intent d = new Intent(PersonalFeedPage.this, ProfilePage.class);
                        startActivity(d);
                        break;
                    case R.id.id_logout:
                        Intent e = new Intent(PersonalFeedPage.this, HomePage.class);
                        startActivity(e);
                        break;
                }
                return false;
            }
        });

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


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                       try {

//                           mTextViewResult.setText("");
                           for (int i = 0; i < response.length(); i++) {
                               JSONObject photo = response.getJSONObject(i);


                               //Get stuff from the photo

                               System.out.println(photo);
                               User sweaty =  new User( 1, "Sweaty", "sweaty@iastate.edu", "user", "pass1234");
                               sweaty.setProfile_pic("https://scontent.fdsm1-1.fna.fbcdn.net/v/t1.0-9/41793156_249057839002346_8937745557640708096_n.jpg?_nc_cat=108&_nc_ohc=BViWIqxmozEAQl1oSq1O5FyPQPGzmQ0ZuyfUrl_lqJ_cLDsDGI_Bz7F8g&_nc_ht=scontent.fdsm1-1.fna&oh=dd2d28d0c055ed87e07db9e564ab9faa&oe=5E6B3834");
                               final User send = new User( 1, "Sweaty", "sweaty@iastate.edu", "user", "pass1234");
                               User alexi=  new User( 2, "Alexis", "sweaty@iastate.edu", "user", "pass1234");
alexi.setProfile_pic("https://scontent-dfw5-2.xx.fbcdn.net/v/t1.0-9/29694394_776603022543974_2417560041001972344_n.jpg?_nc_cat=104&_nc_ohc=Z9MRz-bntOsAQlBAS5kOLharMPJ3RmFKYlHaXWX1TzqvZV3kiQObvbBhg&_nc_ht=scontent-dfw5-2.xx&oh=92ff9f6e499ddbc691b64355b50a3926&oe=5E7358E8");
//                               String picUrl = photo.getString("pic");
                               String picUrl = "http://coms-309-mg-1.cs.iastate.edu/images/pizza.jpg";
                               String caption = photo.getString("caption");
                               String restaurant = photo.getString("restaurant");


//                               User tempUser = new User(photo.getLong(""));

//                               long id = photo.getInt("userId");
//                               String commentC = photo.getString("comment");
                               if(i == 0)
                                    feedPageAdapter.add(new Photo(sweaty, "data:image/jpeg;base64,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", "sweaty pic", "none", "$", "none", "12", 1 )) ;
//                               mTextViewResult.append(id + "\t" + commentC + "\n\n");

                                if (i == 1)
                                feedPageAdapter.add(new Photo (sweaty, "https://i.ndtvimg.com/i/2016-06/chinese-625_625x350_81466064119.jpg", "It was ok", "chinese", "$", "Le's Restaurant", "12", 3));

                                if( i ==2)
                                    feedPageAdapter.add(new Photo (sweaty, "https://data.whicdn.com/images/91274239/original.jpg", "It was ok", "chinese", "$", "Le's Restaurant", "12", 3));

                                if( i ==3 )
                                    feedPageAdapter.add(new Photo (alexi, "https://i.pinimg.com/originals/ce/33/25/ce3325a4947ea5cf19339225aa654abd.jpg", "Most delicious thing EVER.", "chinese", "$", "Le's Restaurant", "12", 3));

                           }


                        } catch (JSONException e) {
//                            mTextViewResult.setText("JSON EXCEPTION");
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

//                mTextViewResult.setText(error.getMessage());
                error.printStackTrace();


            }
        });

        mQueue.add(request);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_screen_navigation, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        //handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.action_message:
                startActivity(new Intent(this, DirectMessage.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}





