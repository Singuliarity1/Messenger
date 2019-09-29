package com.example.messenger;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class PaintMessenger extends Thread {
    private SurfaceHolder holder;
    private boolean start = false;

    public PaintMessenger(SurfaceHolder holder) {
        this.holder = holder;
    }

    public void setRun(boolean start) {
        this.start = start;
    }

    @Override
    public void run() {
        Canvas canvas;
        while (this.start) {
            canvas=null;
            try {
                canvas = holder.lockCanvas();
                synchronized (holder){

                }
            } finally {
                if (canvas != null) {
                    holder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}

