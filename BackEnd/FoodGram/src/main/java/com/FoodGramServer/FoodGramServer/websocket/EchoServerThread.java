package com.FoodGramServer.FoodGramServer.websocket;

import java.io.*;
import java.net.Socket;
import java.util.Vector;

public class EchoServerThread {

    private EchoServer server = null;
    private Socket socket = null;
    private int ID = -1;
    private DataInputStream inStream = null;
    private DataOutputStream outStream = null;
    //private String name = null;
    private boolean firstMessage = true;
    private boolean connected = true;

    public EchoServerThread(EchoServer server, Socket socket) {
        super();
        this.server = server;
        this.socket = socket;
        ID = socket.getPort();
    }

    public void open() throws IOException {
        inStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        outStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }

    public void close() throws IOException {

    }

    public void send(String message) {

    }

    public int getID() {
        return ID;
    }



    public void run() {
        System.out.println("Server Thread " + ID + " connected and runnning.");
        while(connected) {
            try {
                //inStream.readUTF();
                if(firstMessage == true) {
                    //name = inStream.readUTF();
                    server.handle(this, inStream.readUTF());
                    firstMessage = false;
                }else {
                    server.handle(this, inStream.readUTF());
                }
            }catch(IOException ioe) {
                System.out.println(ID + " disconnecting");
                disconnect();

            }
        }
    }

    public void disconnect(){
        connected = false;
        server.remove();
    }
}
