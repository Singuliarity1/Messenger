package com.example.messenger;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class CanvasMessenger {
    Canvas c;
    Paint p;
    public CanvasMessenger(Canvas c){
        this.c=c;
        p=new Paint();
        p.setStrokeWidth(2);
        p.setColor(Color.BLACK);
        c.drawColor(Color.WHITE);
    }

    public void paintCircle(int x,int y, int r){
        c.drawCircle(x,y,r,p);
    }
}