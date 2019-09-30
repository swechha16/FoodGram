package com.foodgram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ResourceCursorAdapter;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

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

        enter_post = (EditText)findViewById(R.id.enter_post);
        Post = (Button) findViewById(R.id.Post);
        Post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = enter_post.getText().toString();
                makePost(data);
            }
        });

    }

    public void welcome_page(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    private void makePost(String data) {

        final String savePost = data;
        String url = "";
        //"http://10.31.24.107:8080/comment/all";

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);

                    Toast.makeText(getApplicationContext(), obj.toString(), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return savePost == null ? null : savePost.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    //Log.v("Unsupported Encoding while trying to get the bytes", data);
                    return null;
                }
            }
        };

        requestQueue.add(stringRequest);
    }

}
