package com.example.messenger;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;

public class PaintActivity extends Activity implements View.OnTouchListener {
    SurfacePaint sp;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        sp=new SurfacePaint(this);
        setContentView(sp);
        sp.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d("EVENT",String.valueOf(event.getX()));
        Log.d("EVENT",String.valueOf(event.getY()));
        sp.setCoordinates((int)event.getX(),(int)event.getY());
        return true;
    }
}
