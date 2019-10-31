package com.FoodGramServer.FoodGramServer.websocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketPracticeClassClient {


    final static int ServerPort = 5000;

    public static void main(String[] args) throws UnknownHostException, IOException {


        Scanner scan = new Scanner(System.in);

        InetAddress address = InetAddress.getByName("localhost");

        Socket socket = new Socket(address, ServerPort);

        DataInputStream input = new DataInputStream(socket.getInputStream());

        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        Thread write = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    // Read what the user wrote
                    String data = scan.nextLine();
                    try {
                        // Output it to the server
                        output.writeUTF(data);
                    }
                    // If that doesn't work, catch the error
                    catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });
        // Thread used to read data sent by the server and other users
        Thread read = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // Read what the server has sent
                        String data = input.readUTF();
                        // Output the data onto the client's console
                        System.out.println(data);
                    }
                    // If that doesn't work, catch the error
                    catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });
        // Start the write thread
        write.start();
        // Start the read thread
        read.start();
    }
}

