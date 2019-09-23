package com.example.messenger;

import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;

public class Holder implements SurfaceHolder.Callback {
    Camera cam;
    Holder(Camera cam){
        this.cam=cam;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        previewCmaera(holder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        cam.stopPreview();
        previewCmaera(holder);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    private void previewCmaera(SurfaceHolder holder){
        try{
            cam.setPreviewDisplay(holder);
            cam.startPreview();
        }catch(Exception e){
            Log.d("HOLDER",String.valueOf(e));
        }
    }
}
