package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
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
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Creates a new user account
 * @author amcordts
 */
public class CreateAccount extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText username;
    private EditText password;
    private EditText account_type;
    private EditText phone;
    private EditText city;
    private EditText state;
    private EditText bio;
    private Button submit;
    private RequestQueue newUser;

    /**
     * This sets up the page and creates the button functionality.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        name = (EditText) findViewById(R.id.input_name);
        email = (EditText)findViewById(R.id.input_email);
        username = (EditText) findViewById(R.id.input_username);
        password = (EditText) findViewById(R.id.input_password);
        account_type = (EditText) findViewById(R.id.input_account);
        phone = (EditText) findViewById(R.id.input_phone);
        city = (EditText) findViewById(R.id.input_city);
        state = (EditText) findViewById(R.id.input_state);
        bio = (EditText) findViewById(R.id.input_bio);
        submit = (Button) findViewById(R.id.createaccount_button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sendContents()== true){
                    //Feed_Page();
                }else{
                    Toast.makeText(getApplicationContext(), "Account Creation Failure", Toast.LENGTH_LONG).show();

                }

            }
        });

    }



    /**
     * Grabs the posts from a user and then sends it to the backend to be posted to
     * the database.
     */
    private boolean sendContents() {
        newUser = Volley.newRequestQueue(this);

        String url = "http://coms-309-mg-1.cs.iastate.edu:8080/post/user";

        final JSONObject user = new JSONObject();
        try {
            user.put("fullName", name.getText().toString());
            user.put("email", email.getText().toString());
            user.put("username", username.getText().toString());
            user.put("password", password.getText().toString());
            user.put("accountType", account_type.getText().toString());
            user.put("locationCity", city.getText().toString());
            user.put("locationState", state.getText().toString());
            user.put("phoneNo", phone.getText().toString());
            user.put("bio", bio.getText().toString());

            Log.d("response", user.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }



        /**
         * Receives response from controller and displays response on Logcat
         * Displays error as text view in the app page when error occurs
         */
        final JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, url, user, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Log.d("Response", response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error.Response", error.toString());

                System.out.println(error.getMessage());
            }

        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

        };
        newUser.add(objectRequest);
        return true;
    }


    public void Feed_Page() {
        Intent intent = new Intent(this, PersonalFeedPage.class);
        startActivity(intent);
    }

}
