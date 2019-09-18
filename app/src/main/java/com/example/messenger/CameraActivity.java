package com.example.messenger;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class CameraActivity extends Activity implements View.OnClickListener {
    File directory;

    ImageView iv;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.camera_layout);
        iv=(ImageView) findViewById(R.id.imageView2);
        createDirectory();
        iv.setOnClickListener(this);
    }

    public void onPhoto(){
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,generateFileUri());
        startActivityForResult(intent,1);
    }

    private Uri generateFileUri(){
        File file=new File(directory.getPath()+"/photo_"+System.currentTimeMillis()+"jpg");
        return Uri.fromFile(file);
    }
    private void createDirectory(){
        directory=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"MyFolder");
        if(!directory.exists()){
            directory.mkdirs();
        }

    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(resultCode==RESULT_OK){

            Object obj=data.getExtras().get("data");
            Bitmap bmp=(Bitmap) obj;
            iv.setImageBitmap(bmp);
        }
    }

    @Override
    public void onClick(View v) {
        onPhoto();
    }
}
