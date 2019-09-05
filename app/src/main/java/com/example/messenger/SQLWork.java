package com.example.messenger;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SQLWork {
    SQLiteDatabase db;
    public SQLWork(SQLiteDatabase db){
        this.db=db;
    }

    public void changeDataBase(SQLiteDatabase db){
        this.db=db;
    }
    public ArrayList<String> getAllMessageFromUser(int user_id){
        String sql="SELECT message FROM messages WHERE id_user="+user_id+" ";
        Cursor c=db.rawQuery(sql,null);
        c.moveToFirst();
        ArrayList<String> list=new ArrayList<String>();

        while(c.isAfterLast()==false){
            list.add(String.valueOf(c.getString(c.getColumnIndex("message"))));
            c.moveToNext();
        }
        c.close();
        return list;
    }
}
