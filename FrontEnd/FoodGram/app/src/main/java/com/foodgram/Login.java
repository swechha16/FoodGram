package com.foodgram;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Verifies the account of a user trying to login with their username and password. Then takes the user to the Feed Page or tells them their login info does not match.
 */
public class Login extends AppCompatActivity {

    private Button FeedHomePage;
    private EditText passwordText;
    private EditText usernameText;

    RequestQueue passQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        passQueue = Volley.newRequestQueue(this);

        FeedHomePage = findViewById(R.id.tryLoginButton);
        passwordText = findViewById(R.id.loginPasswordText);
        usernameText = findViewById(R.id.loginUsernameText);

        FeedHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void Feed_Page() {
        Intent intent = new Intent(this, PersonalFeedPage.class);
        startActivity(intent);
    }

    public void login() {
        final String email = usernameText.getText().toString();
        String url = "http://coms-309-mg-1.cs.iastate.edu:8080/user/email/"+email;
        final String pass = passwordText.getText().toString();
        JsonObjectRequest JSONRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    if(response != null) {
                        String dbEmail = response.getString("email");
                        String dbPassword = response.getString("password");

                        if (pass.equals(dbPassword)) {
                            Feed_Page();
                        } else {
                            Toast.makeText(getApplicationContext(), "Incorrect or Email Password", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "No account by that email", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"JSON ERROR", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        passQueue.add(JSONRequest);

    }
}
