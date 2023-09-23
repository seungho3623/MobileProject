package com.example.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //Log.d("Inha", "ID = " + id + ", PW = " + pw);
        Log.d("Inha", "Sub Activity onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Inha", "Sub Activity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Inha", "Sub Activity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Inha", "Sub Activity onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Inha", "Sub Activity onDestroy");
    }

    @Override
    public void onClick(View view) {

    }
}