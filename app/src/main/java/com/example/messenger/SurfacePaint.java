package com.example.messenger;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfacePaint extends SurfaceView implements SurfaceHolder.Callback, TouchConnect {

    Context ctx;
    PaintMessenger paint;
    SurfacePaint(Context ctx){
        super(ctx);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        paint=new PaintMessenger(holder);
        paint.setRun(true);
        paint.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void setCoordinates(int x, int y) {
        paint.setCoordinates(x,y);
    }
}
