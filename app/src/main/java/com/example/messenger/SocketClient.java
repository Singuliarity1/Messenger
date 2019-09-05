package com.example.messenger;

import android.util.Log;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketClient extends Thread {
    private boolean run=false;
    private Socket client;

    public SocketClient(){

    }
    private void runListenServer(){
        try{
            client=new Socket("15.188.58.119",5189);
            while(true){

            }
        }catch(Exception e){
            Log.d("ERROR SERVER",String.valueOf(e));
        }
    }
    @Override
    public void run(){
        super.run();
    }
}
