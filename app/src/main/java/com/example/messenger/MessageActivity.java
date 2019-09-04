package com.example.messenger;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MessageActivity extends Activity implements View.OnClickListener {
    SQLHelper sql;
    Button btn;
    EditText et;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.messaging_layout);
        sql=new SQLHelper(this);
        btn=(Button) findViewById(R.id.send);
        et=(EditText) findViewById(R.id.message);
        btn.setOnClickListener(this);
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
        ContentValues cv=new ContentValues();
        SQLiteDatabase db=sql.getWritableDatabase();
        cv.put("id_user",12);
        cv.put("message", String.valueOf(et.getText()));
        db.insert("messages",null,cv);

    }
}
