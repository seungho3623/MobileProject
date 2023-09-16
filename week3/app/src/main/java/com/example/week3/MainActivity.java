package com.example.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etID;
    EditText etPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Inha", "Main");

        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText("Login");

        etID = (EditText) findViewById(R.id.LoginId);
        etPW = (EditText) findViewById(R.id.LoginPassword);
        Button bt = (Button) findViewById(R.id.LoginButton);

        bt.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Inha", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Inha", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Inha", "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Inha", "onDestroy");
    }

    @Override
    public void onClick(View view) {
        String id = etID.getText().toString();
        String pw = etPW.getText().toString();

        Intent intent = new Intent(this, SubActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("pw", pw);
        startActivity(intent);
    }
}