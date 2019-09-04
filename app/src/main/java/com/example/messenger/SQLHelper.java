package com.example.messenger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLHelper extends SQLiteOpenHelper {

    public SQLHelper(Context ctx){
        super(ctx,"messages",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("SQLITE","DATABSE CREATE");
        db.execSQL("create table messages( id integer primary key autoincrement,"
                +"id_user integer,"
                +"message text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
