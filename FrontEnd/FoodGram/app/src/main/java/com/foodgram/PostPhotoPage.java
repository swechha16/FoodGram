package com.foodgram;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * Posts a photo
 * @Alexi
 * @SKarn
 */
public class PostPhotoPage extends AppCompatActivity {

    ImageView postImage;
    private TextView mTextViewResult;

    private Button signOut, add_post;

    private EditText txt_caption, txt_foodTag, txt_costTag,txt_restaurant;

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_photo_page);

        User account = new User(1, "sweaty",  "sghimire@iastate.edu", "user", "1234");
        signOut = (Button) findViewById(R.id.signOut_post);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                welcome_page();
            }
        });

        txt_caption = (EditText) findViewById(R.id.post_caption);
        txt_foodTag = (EditText) findViewById(R.id.post_foodTag);
        txt_costTag = (EditText) findViewById(R.id.post_costTag);
        txt_restaurant = (EditText) findViewById(R.id.post_restaurant);

        postImage = (ImageView)findViewById(R.id.post_img);

        add_post = (Button) findViewById(R.id.btn_post);
        add_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendContents();
            }
        });

        postImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImgUpload();
            }
        });


        mTextViewResult = findViewById(R.id.errorView);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent a = new Intent(PostPhotoPage.this, PersonalFeedPage.class);
                        startActivity(a);
                        break;
                    case R.id.action_search:
                        Intent b = new Intent(PostPhotoPage.this, FilteredFoodFeed.class);
                        startActivity(b);
                        break;
                    case R.id.action_add_post:
//                        Intent c = new Intent(HomePageWithFeedPost.this, PostPhotoPage.class);
//                        startActivity(c);
                        break;
                    case R.id.action_about:
                        Intent d = new Intent(PostPhotoPage.this, ProfilePage.class);
                        startActivity(d);
                        break;
                    case R.id.id_logout:
                        Intent e = new Intent(PostPhotoPage.this, HomePage.class);
                        startActivity(e);
                        break;
                }
                return false;
            }
        });

    }

    /**
     * Takes a user to the welcome page
     */
    public void welcome_page() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    /**
     * Grabs the posts from a user and then sends it to the backend to be posted to
     * the database.
     */
    private void sendContents() {

        requestQueue = Volley.newRequestQueue(this);
        String url = "http://10.9.213.42:8080/post/photo";


        final JSONObject obj = new JSONObject();
        final JSONObject user = new JSONObject();
        User account = new User(1, "sweaty",  "sghimire@iastate.edu", "user", "1234");
        try {
            user.put("userId", account.getUser_id());
            obj.put("pic", "url");
            obj.put("caption", (txt_caption.getText()).toString());
            obj.put("restaurant", (txt_restaurant.getText()).toString());
            obj.put("user", user);
            obj.put("foodTag", (txt_foodTag.getText()).toString());
            obj.put("costTag", (txt_costTag.getText()).toString());

            Log.d("Response", obj.toString());

        }
        catch (JSONException e){
            e.printStackTrace();
        }

        /**
         * Receives response from controller and displays response on Logcat
         */
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Log.d("Response", response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error.Response", error.toString());

                if (error instanceof TimeoutError || error instanceof NoConnectionError){
                    mTextViewResult.setText("Timeout Error or No connection error");
                }
                else if(error instanceof AuthFailureError){
                    mTextViewResult.setText("authentication failure error");
                }else if(error instanceof ServerError){
                    mTextViewResult.setText("server error");
                }else if(error instanceof NetworkError){
                    mTextViewResult.setText("network error");
                }else if(error instanceof ParseError){
                    mTextViewResult.setText("Parse Error");
                }

            }

        }) ;



        requestQueue.add(objectRequest);

    }

    private void selectImgUpload(){
        final CharSequence[] options = {"Take Photo","Choose from Gallery","Cancel"};
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(PostPhotoPage.this);
        builder.setTitle("Choose an Option");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int items) {
                if(options[items].equals("Take Photo")){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File f = new File(android.os.Environment.getExternalStorageDirectory(), "photo.jpg");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(intent, 1);
                }
                else if (options[items].equals("Choose From Gallery")){
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);
                }
                else if (options[items].equals("Cancel")){
                    dialogInterface.dismiss();
                }
            }
        });
        builder.show();
    }

}
