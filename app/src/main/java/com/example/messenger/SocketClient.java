package com.example.messenger;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketClient extends Thread {
    private boolean run=false;
    private Socket client;
    private BufferedReader out;
    private BufferedWriter in;
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

    public String getServerData(){
        String answer="";
        try{
            out=new BufferedReader(new InputStreamReader(client.getInputStream()));
            answer=out.readLine();
        }catch(Exception e){
            answer=String.valueOf(e);
        }
        return answer;

    }

    public void setServerData(String text){
        try {
            in = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            in.write(text+'\n');
            in.flush();
        }catch(Exception e){
            Log.d("ERROR send on server",String.valueOf(e));
        }
    }


}
