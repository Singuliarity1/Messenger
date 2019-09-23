package com.example.messenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button start,reg,exit;
    Intent intent;
    SoundMaker sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button) findViewById(R.id.start);
        reg=(Button) findViewById(R.id.registration);
        exit=(Button) findViewById(R.id.exit);
        start.setOnClickListener(this);
        reg.setOnClickListener(this);
        exit.setOnClickListener(this);
        sound=new SoundMaker(this);
        sound.start();
        Log.d("STATUS","START");
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.start:
                intent=new Intent(this,SoundRecord.class);

                break;
            case R.id.registration:
                intent=new Intent(this,RegisrtationActivity.class);

                break;
            case R.id.exit:

                break;
        }
        startActivity(intent);
    }
}
