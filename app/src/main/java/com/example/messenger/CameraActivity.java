package com.example.messenger;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class CameraActivity extends Activity implements View.OnClickListener {
    File directory;
    Camera camera;
    ImageView iv;
    Holder holder;
    final int CAMRERA_ID=Camera.CameraInfo.CAMERA_FACING_BACK;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        cameraClear();
        camera=Camera.open(CAMRERA_ID);
        holder=new Holder(camera);
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

    @Override
    protected void onResume(){
        super.onResume();
        camera=Camera.open(CAMRERA_ID);
    }

    @Override
    protected void onPause(){
        super.onPause();
        cameraClear();

    }

    void cameraClear(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 50);

        if(camera!=null){
            camera.lock();
            camera.stopPreview();
            camera.release();
            camera=null;
        }
    }
}
