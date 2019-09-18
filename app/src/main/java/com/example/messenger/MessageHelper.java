package com.example.messenger;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class MessageHelper {
    Context ctx;
    public MessageHelper(){

    }

    public static void showMessage(Context ctx,String message){
        Log.d("Show text","SHOW TEXT");
        Toast.makeText(ctx,message,Toast.LENGTH_LONG).show();
    }
}
