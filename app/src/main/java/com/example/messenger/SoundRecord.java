package com.example.messenger;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class SoundRecord extends Activity implements View.OnClickListener {
    Button start,stop,release;
    SoundMaker sm;
    Uri uri;
    MediaRecorder mr;
    String fileName="";
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.sound_record_layout);
        start=(Button) findViewById(R.id.record);
        start.setOnClickListener(this);

        stop=(Button) findViewById(R.id.stop);
        stop.setOnClickListener(this);

        release=(Button) findViewById(R.id.release);
        release.setOnClickListener(this);

        sm=new SoundMaker(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.record:
                if(ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO},0);
                }

                if(ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
                }
                record();
                break;

            case R.id.stop:
                stopRecord();
                break;

            case R.id.release:
                releaseRecord();
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void record(){


        fileName= this.getFilesDir()+"/"+randomFileName(5)+".3gpp";
        File file=new File(fileName);
        while(file.exists()){
           file.renameTo(new File(getCopyFileName(fileName)));
        }
       try {
           mr = new MediaRecorder();
           mr.setAudioSource(MediaRecorder.AudioSource.MIC);
           mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
           mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
           mr.setOutputFile(fileName);
           mr.prepare();
           mr.start();
       }catch(IOException e){
           Log.d("ERROR RECORD",String.valueOf(e));

       }
        MessageHelper.showMessage(this,fileName);
    }
    private String getCopyFileName(String filaname){
        String newFileName="";
        String[] fileAr=filaname.split("/");
        int length=fileAr.length-1;
        String fileNameInAr=fileAr[length].split(".")[0]+"_1";
        for(int i=0;i<length;i++){
            newFileName+=fileAr[i];
        }
        newFileName+=fileNameInAr;
        return newFileName;
    }
    public void releaseRecord(){
        if(mr!=null){
            mr.release();
        }
    }

    public void stopRecord(){
        if(mr!=null){
            mr.stop();
        }
    }

    private String randomFileName(int length){
        String[] abc={"q","w","e","r","t","y","u","i","o","p","a","s",
                      "d","f","g","h","j","k","l","z","x","c","v","b","n","m","_"};
        String str="";
        int lengthAbc=abc.length-1;
        for(int i=0;i<=length;i++){
            str+=abc[(int) Math.round(Math.random()*lengthAbc)];
        }
        return str;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        if(requestCode == 1){
            uri=intent.getData();
            sm.playRecordedSound(uri);
            MessageHelper.showMessage(this,String.valueOf(uri.getPath()));
        }
    }
}
