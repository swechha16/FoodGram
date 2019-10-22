package com.foodgram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import java.io.UnsupportedEncodingException;

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

        add_post = (Button) findViewById(R.id.btn_post);
        add_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendContents();
            }
        });

        mTextViewResult = findViewById(R.id.errorView);

    }

    public void welcome_page() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    private void sendContents() {

        requestQueue = Volley.newRequestQueue(this);
        //String url = "http://10.65.23.83:8080/post/comment/users";
        //String url = "http://10.31.4.129:8080/post/photo";
        String url = "http://10.29.178.67:8080/post/photo";
       // String url = "http://coms-309-mg-1.cs.iastate.edu:8080/photo/post";
        //String url = "http://10.31.31.154:8080/post/comment";
        //"http://10.31.24.107:8080/comment/all";

        final JSONObject obj = new JSONObject();
        try {
//            obj.put("caption", (txt_caption.getText()).toString());
//            obj.put("food tag", (txt_foodTag.getText()).toString());
//            obj.put("cost tag", (txt_costTag.getText()).toString());
//            obj.put("restaurant", (txt_restaurant.getText()).toString());


            obj.put("pic", "I DON'T CARE");
            obj.put("caption", "Hello");
            obj.put("cost_tag", "$$$");

            obj.put("food_tag",  "italian");
            obj.put("restaurant", "I DON'T CARE");
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Log.d("Response", response.toString());

                mTextViewResult.setText("onResponse");

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              //  VolleyLog.d("Error.Response", error.toString());

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

//        {
//            @Override
//            public String getBodyContentType() {
//                return "application/json; charset=utf-8";
//            }
//
////            @Override
////            public byte[] getBody() throws AuthFailureError {
////                try {
////                    return obj == null ? null : obj.getBytes("utf-8");
////                } catch (UnsupportedEncodingException uee) {
////                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", obj, "utf-8");
////                    return null;
////                }
////
////            }
//        };

        requestQueue.add(objectRequest);

    }

}
