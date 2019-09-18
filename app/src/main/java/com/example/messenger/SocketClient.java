package com.example.messenger;

import android.os.AsyncTask;
import android.util.Log;

import java.io.*;
import java.net.Socket;

public class SocketClient extends AsyncTask<Void,Void,Void> {

    private Socket client;
    private BufferedReader out;
    private DataOutputStream  in;


    @Override
    protected Void doInBackground(Void... voids) {
        this.runListenServer();
        return null;
    }

    private void runListenServer(){
        try{
            byte[] b={12,45,35};
            client=new Socket("15.188.58.119",5891);
            client.getOutputStream().write(b);
            client.getOutputStream().flush();
            Log.d("SERVER",String.valueOf("client connected"));
        }catch(Exception e){
            Log.d("ERROR SERVER",String.valueOf(e));
        }
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
            in = new DataOutputStream (client.getOutputStream());
            in.writeUTF(text);
            in.flush();

            Log.d("SERVER","Message send");
        }catch(Exception e){
            Log.d("ERROR send on server",String.valueOf(e));
        }
    }


}
