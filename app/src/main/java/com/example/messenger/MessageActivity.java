package com.example.messenger;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageActivity extends Activity implements View.OnClickListener {
    SQLHelper sql;
    SQLiteDatabase db;
    Button btn;
    EditText et;
    LinearLayout ll;
    Intent intent;
    int id_user;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.messaging_layout);
        sql=new SQLHelper(this);
        btn=(Button) findViewById(R.id.send);
        et=(EditText) findViewById(R.id.message);
        ll=(LinearLayout) findViewById(R.id.layout);
        btn.setOnClickListener(this);
        db=sql.getWritableDatabase();

        intent=getIntent();
        id_user=(int) intent.getIntExtra("id_user",0);
        loadAllMessage(db);
        Log.d("id_user",String.valueOf(id_user));
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.send:
                sendMessage();
                break;
        }
    }

    private void sendMessage(){
        String message=String.valueOf(et.getText());
        if(message.replaceAll("\\s","")!="") {
            ContentValues cv = new ContentValues();
            cv.put("id_user", id_user);
            cv.put("message", message);
            db.insert("messages", null, cv);
            addMessage(message);
        }
    }
    private void loadAllMessage(SQLiteDatabase db){

        SQLWork sql=new SQLWork(db);
        ArrayList<String> as=sql.getAllMessageFromUser(id_user);
        for(int i=0;i<as.size();i++){
            TextView tv=new TextView(this);
            tv.setText(as.get(i));
            ll.addView(tv);
        }
    }
    private void addMessage(String message){
        et.setText("");
        TextView tv =new TextView(this);
        tv.setText(message);
        ll.addView(tv);
    }
}
