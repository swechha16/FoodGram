package com.foodgram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class MakePostPage extends AppCompatActivity {

    private Button signOut;

    private RequestQueue requestQueue;

    private EditText enter_post;
    private Button Post;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_post_page);

        signOut = (Button) findViewById(R.id.signOut_post);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcome_page();
            }
        });

        enter_post = (EditText) findViewById(R.id.enter_post);
        Post = (Button) findViewById(R.id.Post);
        Post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String data = enter_post.getText().toString();
                makePost();
            }
        });


    }

    public void welcome_page() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    private void makePost() {

        requestQueue = Volley.newRequestQueue(this);
        //String url = "http://10.65.23.83:8080/post/comment/users";
        String url = "http://10.9.213.207:8080/post/comment/users";
        //JSONObject jsonBody = new JSONObject();
        final String makePost = enter_post.getText().toString();
        //String url = "http://coms-309-mg-1.cs.iastate.edu:8080/post/comment/users";
        //String url = "http://10.31.31.154:8080/post/comment";
        //"http://10.31.24.107:8080/comment/all";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("Response", response);

                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error.Response", error.toString());
            }

        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return makePost == null ? null : makePost.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", makePost, "utf-8");
                    return null;
                }

            }
        };

        requestQueue.add(stringRequest);
    }

}
