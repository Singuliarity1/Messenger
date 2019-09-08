package com.example.messenger;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class SoundMaker {
    private MediaPlayer mp;
    Context ctx;
    public SoundMaker(Context ctx){
        this.ctx=ctx;
    }

    public void sendMessage(){
        this.mp=MediaPlayer.create(ctx,R.raw.send_message);
        this.mp.start();
        Log.d("SOUND","PLAY");
    }
}
