package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;


import org.java_websocket.drafts.Draft;



/**
 * A chat for users to communicate directly with each other.
 */
public class DirectMessage extends AppCompatActivity {



        Button b1, b2;
        EditText e1, e2;
        TextView t1;

        private WebSocketClient cc;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_direct_message);
            b1 = findViewById(R.id.ConnectButton);
            b2 = findViewById(R.id.sendMessageButton);
            e1 = findViewById(R.id.userNameInput);
            e2 = findViewById(R.id.messageTextView);
            t1 = findViewById(R.id.messageView);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Draft[] drafts = {new Draft_6455()};

                    /**
                     * If running this on an android device, make sure it is on the same network as your
                     * computer, and change the ip address to that of your computer.
                     * If running on the emulator, you can use localhost.
                     */
                    String w = "ws://10.26.13.93:8080/websocket/" + e1.getText().toString();

                    try {
                        Log.d("Socket:", "Trying socket");
                        cc = new WebSocketClient(new URI(w), (Draft) drafts[0]) {
                            @Override
                            public void onMessage(String message) {
                                Log.d("", "run() returned: " + message);
                                String s = t1.getText().toString();
                                //t1.setText("hello world");
                                //Log.d("first", "run() returned: " + s);
                                //s=t1.getText().toString();
                                //Log.d("second", "run() returned: " + s);
                                t1.setText(s + " Server:" + message);
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

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        cc.send(e2.getText().toString());
                    } catch (Exception e) {
                        Log.d("ExceptionSendMessage:", e.getMessage().toString());
                    }
                }
            });
        }
    }

