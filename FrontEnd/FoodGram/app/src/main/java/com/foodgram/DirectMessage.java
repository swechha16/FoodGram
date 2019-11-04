package com.foodgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class DirectMessage extends AppCompatActivity {
        String url = "Enter url to communicate with websocket";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_message);
        WebSocketClient ws = new WebSocketClient(new URI( ws:hostname:8080/chat/ronnie)) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {

            }

            @Override
            public void onMessage(String s) {

            }

            @Override
            public void onClose(int i, String s, boolean b) {

            }

            @Override
            public void onError(Exception e) {

            }
        }
    }
}
