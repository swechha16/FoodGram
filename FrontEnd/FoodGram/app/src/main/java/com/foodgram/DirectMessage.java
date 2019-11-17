package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.foodgram.Direct_Messaging.Chat;
import com.foodgram.Direct_Messaging.RecyclerViewMessageAdapter;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


import org.java_websocket.drafts.Draft;


/**
 * A chat for users to communicate directly with each other.
 */
public class DirectMessage extends AppCompatActivity {



        ImageButton connect; //user should click on user image to send username
        ImageButton sendMessageButton;

        EditText usernameInput, messageInput;

        private WebSocketClient cc;

        RecyclerView messageView;


        List<Chat> mChat;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_direct_message);
            connect = findViewById(R.id.username_input_btn);
            sendMessageButton = findViewById(R.id.send_button);
            usernameInput = findViewById(R.id.username);
            messageInput = findViewById(R.id.textSend);

            //Recycler view stuff
            messageView = (RecyclerView) findViewById(R.id.message_view);
            RecyclerViewMessageAdapter messageListAdapter = new RecyclerViewMessageAdapter(this, mChat);

            messageView.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
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
                    String w = "ws://10.26.13.192:8080/websocket/" + usernameInput.getText().toString();

                    try {
                        Log.d("Socket:", "Trying socket");
                        cc = new WebSocketClient(new URI(w), drafts[0]) {
                            @Override
                            public void onMessage(String message) {
                                Log.d("", "run() returned: " + message);
//                                String s = t1.getText().toString();
                                mChat.add(new Chat (2,1, "Hello"));
//                                t1.setText(s + " Server:" + message);
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
                        Log.d("Exception:", e.getMessage().toString());
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
                        mChat.add(new Chat(1,2,messageInput.getText().toString()));
                    } catch (Exception e) {
                        Log.d("ExceptionSendMessage:", e.getMessage().toString());
                    }
                }
            });
        }



    }

