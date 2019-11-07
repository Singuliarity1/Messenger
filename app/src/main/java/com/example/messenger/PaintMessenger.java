package com.example.messenger;

import android.content.Context;
import android.content.ReceiverCallNotAllowedException;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;

import java.util.ArrayList;

public class PaintMessenger extends Thread implements TouchConnect{
    private SurfaceHolder holder;
    private boolean start = false;
    private int x,y;
    public GUIEvent cleanLast,cleanAll;
    private ArrayList<int[]> coordinates_all;
    Context ctx;
    public PaintMessenger(SurfaceHolder holder) {

        this.holder = holder;
        coordinates_all=new ArrayList<int[]>();
    }

    public void setContext(Context ctx){
        this.ctx=ctx;

    }

    public void setRun(boolean start) {

        this.start = start;
    }


    @Override
    public void run() {
        Canvas canvas;
        cleanLast= (x,y,w,h,c)->{
            Paint p=new Paint();
            p.setColor(Color.GRAY);
            p.setStrokeWidth(2);
            Rect rect=new Rect(x,y,x+w,y+h);
            c.drawRect(rect,p);
        };
        CanvasBuilder cb=new CanvasBuilder();
        while (this.start) {
            canvas=null;
            try {
                canvas = holder.lockCanvas();
                synchronized (holder){
                    cb.setCanvas(canvas);
                    cb.setAllCorrdinates(coordinates_all);
                    cb.paintAllLines();
                    cleanLast.event(0,0,100,100,canvas);
                    cleanLast.event(300,0,100,100,canvas);
                }
            } finally {
                if (canvas != null) {
                    holder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    @Override
    public void setCoordinates(int x, int y) {

        coordinates_all.add(new int[]{x,y});
    }
}

