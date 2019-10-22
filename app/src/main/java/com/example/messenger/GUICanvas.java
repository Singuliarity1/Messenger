package com.example.messenger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

public class GUICanvas
{
    Canvas c;
    Paint p;
    ArrayList<GUIEvent> event;
    int width,height;
    int x,y;
    GUICanvas(){
        p=new Paint();
        p.setStrokeWidth(2);
        p.setColor(Color.BLACK);
        event=new ArrayList<GUIEvent>();
    }

    public void setCanvas(Canvas c){
        this.c=c;
    }

    public void positionSize(int x,int y,int width,int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }

    public void paintButton(){
        c.drawRect(new Rect(x,y,x+width,y+height),p);
    }

    public void addEventOnCanvas(GUIEvent gui){
        event.add(gui);
    }


}
