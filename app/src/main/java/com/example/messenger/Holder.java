package com.example.messenger;

import android.graphics.Camera;
import android.view.SurfaceHolder;

public class Holder implements SurfaceHolder.Callback {
    Camera cam;
    Holder(Camera cam){
        this.cam=cam;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
