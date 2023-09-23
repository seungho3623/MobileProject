package com.example.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Log.d("Inha", "Third Activity onCreate");

        Button uriButton = (Button) findViewById(R.id.UriButton);
        uriButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.inha.ac.kr"));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Inha", "Third Activity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Inha", "Third Activity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Inha", "Third Activity onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Inha", "Third Activity onDestroy");
    }

}