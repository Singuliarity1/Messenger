package com.example.messenger;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

public class CanvasBuilder {
    Canvas c;
    ArrayList<int[]> coordinates_all;
    Paint p;
    CanvasBuilder(){
        p=new Paint();
        p.setStrokeWidth(2);
        p.setColor(Color.BLACK);
    }

    public void setCanvas(Canvas c){
        this.c=c;
        this.c.drawColor(Color.WHITE);
    }

    public void setAllCorrdinates(  ArrayList<int[]> coordinates_all){
        this.coordinates_all=coordinates_all;
    }

    public void paintAllLines(){
        int size=coordinates_all.size();
        for(int i=1;i<size;i++){
            int x_new=coordinates_all.get(i)[0];
            int y_new=coordinates_all.get(i)[1];

            int x_old=coordinates_all.get(i-1)[0];
            int y_old=coordinates_all.get(i-1)[1];
            c.drawLine(x_old,y_old,x_new,y_new,p);
        }
    }

    public ArrayList<int[]> deleteLastLine(ArrayList<int[]> coordinates_all){
        ArrayList<int[]> new_coordinates=coordinates_all;
        new_coordinates.remove(new_coordinates.size()-1);
        return new_coordinates;
    }

    public ArrayList<int[]> clearAll(){
        ArrayList<int[]> creared=new ArrayList<int[]>();
        return creared;
    }
}
