package com.example.messenger;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;

import java.io.IOException;

public class SoundMaker {
    private MediaPlayer mp;
    private AudioManager am;
    Context ctx;
    public SoundMaker(Context ctx){
        this.ctx=ctx;
        am=(AudioManager) ctx.getSystemService(Context.AUDIO_SERVICE);
        am.setStreamVolume(AudioManager.STREAM_MUSIC,am.getStreamMaxVolume(AudioManager.STREAM_ALARM),0);
    }

    public void sendMessage(){

        playSound(R.raw.oxp);
        Log.d("SOUND","PLAY");
    }

    public void start(){
        playSound(R.raw.oxp);
        Log.d("SOUND","START");
    }

    void playSound(int id){
        mp=MediaPlayer.create(ctx,id);
        mp.start();
    }

    void playRecordedSound(Uri uri){
        mp=new MediaPlayer();
        try {
            mp.setDataSource(ctx, uri);
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp.prepare();
            mp.start();
        }catch(IOException e){
            Log.d("AUDIO PLAY",String.valueOf(e));
        }
    }


}
