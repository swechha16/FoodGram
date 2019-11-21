package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
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

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import org.java_websocket.drafts.Draft;
import org.json.JSONException;
import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A chat for users to communicate directly with each other.
 */
public class DirectMessage extends AppCompatActivity {

    private RequestQueue requestQueue;



        ImageButton connect; //user should click on user image to send username
        ImageButton sendMessageButton;

        EditText usernameInput, messageInput;

        private WebSocketClient cc;

        RecyclerView messageView;
    RecyclerViewMessageAdapter messageListAdapter ;
String sender;

        List<Chat> mChat;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_direct_message);


            connect = findViewById(R.id.username_input_btn);
            sendMessageButton = findViewById(R.id.send_button);
            usernameInput = findViewById(R.id.username);
            messageInput = findViewById(R.id.textSend);

            mChat = new ArrayList<Chat>();

            //Recycler view stuff
            messageView = (RecyclerView) findViewById(R.id.message_view);
            messageListAdapter = new RecyclerViewMessageAdapter(this, mChat);
            messageView.setAdapter(messageListAdapter);
            messageView.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            messageView.setLayoutManager(linearLayoutManager);

            connect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Draft[] drafts = {new Draft_6455()};

                    /**
                     * If running this on an android device, make sure it is on the same network as your
                     * computer, and change the ip address to that of your computer.
                     * If running on the emulator, you can use localhost.
                     */

                    sender = usernameInput.getText().toString();
                    String w = "ws://10.26.50.201:8080/websocket/" + sender;

                    try {
                        Log.d("Socket:", "Trying socket");
                        cc = new WebSocketClient(new URI(w), drafts[0]) {
                            @Override
                            public void onMessage(String message) {
                                Log.d("", "run() returned: " + message);
//                                String s = t1.getText().toString();
//                                mChat.add(new Chat (2,1, message));
                                Scanner scanner = new Scanner(message);
                                String messageFrom = scanner.next();

                                if(!messageFrom.trim().equals("User:")) {
                                    if (messageFrom.equals(sender + ":")) {
                                        messageListAdapter.add(new Chat(1, 2, message));
                                    } else
                                        messageListAdapter.add(new Chat(2, 1, message));
                                }else{
                                    Toast toast = Toast.makeText(DirectMessage.this, messageFrom, Toast.LENGTH_LONG);
                                            toast.setGravity(Gravity.TOP|Gravity.RIGHT, 0,0);
                                            toast.show();
                                }

                                storeMessage(message);

                            }

                            @Override
                            public void onOpen(ServerHandshake handshake) {
                                Log.d("OPEN", "run() returned: " + "is connecting");
                            }

                            @Override
                            public void onClose(int code, String reason, boolean remote) {
                                Log.d("CLOSE", "onClose() returned: " + reason);
                            }

                            @Override
                            public void onError(Exception e) {
                                Log.d("Exception:", e.toString());
                            }
                        };
                    } catch (URISyntaxException e) {
                        Log.d("Exception:", e.getMessage());
                        e.printStackTrace();
                    }
                    cc.connect();

                }
            });

            sendMessageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        cc.send(messageInput.getText().toString());
//                        mChat.add(new Chat(1,2,messageInput.getText().toString()));

                    } catch (Exception e) {
                        Log.d("ExceptionSendMessage:", e.getMessage());
                    }
                }
            });
        }
//
//        public void updateAdapter(List<Chat> c){
//            messageListAdapter = new RecyclerViewMessageAdapter(this, mChat);
//        }

    public void storeMessage(String message){
//        requestQueue = Volley.newRequestQueue(this);
//        //String url = "http://10.65.23.83:8080/post/comment/users";
//        //String url = "http://10.31.4.129:8080/post/photo";
//        String url = "http://10.9.213.42:8080/websocket/";
//        // String url = "http://coms-309-mg-1.cs.iastate.edu:8080/photo/post";
//        //String url = "http://10.31.31.154:8080/post/comment";
//        //"http://10.31.24.107:8080/comment/all";
//
//        final JSONObject obj = new JSONObject();
//        final JSONObject user = new JSONObject();
//        User account = new User(1, "sweaty",  "sghimire@iastate.edu", "user", "1234");
//        try {
//            user.put("userId", account.getUser_id());
//            obj.put("pic", "url");
//            obj.put("caption", (txt_caption.getText()).toString());
//            obj.put("restaurant", (txt_restaurant.getText()).toString());
//            obj.put("user", user);
//            obj.put("foodTag", (txt_foodTag.getText()).toString());
//            obj.put("costTag", (txt_costTag.getText()).toString());
//
//            Log.d("Response", obj.toString());
//
//        }
//        catch (JSONException e){
//            e.printStackTrace();
//        }
//
//        /**
//         * Receives response from controller and displays response on Logcat
//         */
//        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {
//
//            @Override
//            public void onResponse(JSONObject response) {
//
//                Log.d("Response", response.toString());
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d("Error.Response", error.toString());
//
//                if (error instanceof TimeoutError || error instanceof NoConnectionError){
//                    mTextViewResult.setText("Timeout Error or No connection error");
//                }
//                else if(error instanceof AuthFailureError){
//                    mTextViewResult.setText("authentication failure error");
//                }else if(error instanceof ServerError){
//                    mTextViewResult.setText("server error");
//                }else if(error instanceof NetworkError){
//                    mTextViewResult.setText("network error");
//                }else if(error instanceof ParseError){
//                    mTextViewResult.setText("Parse Error");
//                }
//
//            }
//
//        }) ;

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

//        requestQueue.add(objectRequest);



    }



    }

