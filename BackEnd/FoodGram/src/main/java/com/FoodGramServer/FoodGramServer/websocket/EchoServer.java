package com.FoodGramServer.FoodGramServer.websocket;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class EchoServer implements Runnable {


    private ServerSocket serverSock = null;
    private Thread thread = null;
    static Vector<EchoServerThread> ar = new Vector<>();
    private static int numOnlineUsers = 0;



    public EchoServer(int port, boolean start) {

    }
    @Override
    public void run() {
        System.out.println("EchoServer started.");
        while (thread != null) {
//            try{
//              //  addThread(socket.accept());
//            }catch(IOException e){
//                System.out.println("Failure adding thread: " + e.getMessage());
//            }
//        }
        }
    }

    public void start() {

    }

    public void addThread() {

    }

    public void stop() {

    }


    public synchronized void handle(EchoServerThread handleThread, String input) {

        System.out.println(handleThread.getID() + ": " + input);

        handleThread.send(input);

    }

    public void remove() {

    }

    public int getNumOnlineUsers(){
        return 1;
    }




    private void disconnectFromServer() {
    }

}