package com.example.week7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        //WebView webView = (WebView) findViewById(R.id.WebView);
        //webView.loadUrl("https://m.naver.com");

        //boolean ret = isExternalStorageWritable();
        //Toast.makeText(this, "ExternalStorage result : " + ret, Toast.LENGTH_SHORT).show();
    }

    public static boolean isExternalStorageWritable(){
        String state = Environment.getExternalStorageState();
        return (Environment.MEDIA_MOUNTED.equals(state)) ?  true : false;
    }

    @Override
    public void onClick(View v) {
        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE);

        if(permissionCheck == PackageManager.PERMISSION_DENIED){
            //권한이 없음
            //런타임 퍼미션 획득
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        }else{
            //권한이 있음
            Toast.makeText(this, "권한 있음", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 0) {
            if(grantResults[0] == 0) {
                //권한이 있음
                Toast.makeText(this, "권한 획득", Toast.LENGTH_SHORT).show();
            }else{
                //거부
                Toast.makeText(this, "거부", Toast.LENGTH_SHORT).show();
            }
        }
    }
}