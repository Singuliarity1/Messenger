package com.example.messenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends Activity implements View.OnClickListener {
    Button btn;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.start_layout);
        btn=(Button) findViewById(R.id.messaging);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.messaging:
                Intent intent=new Intent(this,MessageActivity.class);
                startActivity(intent);
                break;
        }
    }
}
