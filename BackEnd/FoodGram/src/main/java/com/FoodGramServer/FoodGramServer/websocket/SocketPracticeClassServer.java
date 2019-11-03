package com.FoodGramServer.FoodGramServer.websocket;

import org.apache.catalina.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;
import java.net.*;
import java.io.*;
import java.util.*;

public class SocketPracticeClassServer {
    // Vector for active clients
    static Vector<ClientHandler> ar = new Vector<>();
    // String for storing client name
    public static String name;

    public static void main(String[] args) throws IOException {
        // Server is listening on port 5000
        ServerSocket ServSock = new ServerSocket(5000);
        // Socket that we will be using
        Socket socket;
        // Scanner for taking in name
        Scanner scan = new Scanner(System.in);
        // Loop waiting for client requests
        while (true) {
            // Accept requests
            socket = ServSock.accept();
            // Set up input stream to get data from clients
            DataInputStream input = new DataInputStream(socket.getInputStream());
            // Set up output stream to send data to clients
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            // Prompt the user to enter their name
            output.writeUTF(">Enter your name:");
            // Store their name
            name = input.readUTF();
            // Inform the user and the server that user has been successfully added
            output.writeUTF("Thanks " + name + ", you have successfully been added on socket: " + socket);
            System.out.println(name + " has been successfully added on socket: " + socket);
            // Establish the handler class to handle the client
            ClientHandler handler = new ClientHandler(name, input, output);
            // Establish new thread for client
            Thread newThread = new Thread(handler);
            // Add client to server array
            ar.add(handler);
            // Start the client's thread
            newThread.start();
        }
    }
}

class ClientHandler implements Runnable {
    // String for storing client name
    private String name;
    // Input stream to get data from clients
    final DataInputStream input;
    // Output stream for sending data to clients
    final DataOutputStream output;

    public ClientHandler(String name, DataInputStream input, DataOutputStream output) {
        this.input = input;
        this.output = output;
        this.name = name;
    }
    @Override
    public void run() {
        // String for storing data that user sends
        String data;
        while (true) {
            try {
                // Store the data the user sent
                data = input.readUTF();
                // Print the data to the servers console
                System.out.println(name + ": " + data);
                // For ever client currently connecter to the server
                for (ClientHandler cl : SocketPracticeClassServer.ar) {
                    // If the client name is not the name of the sending client
                    if (!(cl.name.equals(this.name))) {
                        // Send the sending client's name and what they said to the receiving clients
                        cl.output.writeUTF(this.name + ": " + data);
                    }
                }
            }
            // Catches the IO exception
            catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
