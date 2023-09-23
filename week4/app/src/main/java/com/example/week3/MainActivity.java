package com.example.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AssetFileDescriptor descriptor;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Inha", "Main Activity onCreate");
        AssetManager assetManager = getAssets();
        try {
            descriptor = assetManager.openFd("just_dance.mp3");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Button bt1 = (Button) findViewById(R.id.button1);
        Button bt2 = (Button) findViewById(R.id.button2);
        Button playButton = (Button) findViewById(R.id.buttonPlay);
        Button stopButton = (Button) findViewById(R.id.buttonStop);
        Button rawButton = (Button) findViewById(R.id.buttonRaw);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(intent);
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(descriptor.getFileDescriptor(),
                            descriptor.getStartOffset(), descriptor.getLength());
                    descriptor.close();
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(mediaPlayer != null) mediaPlayer.stop();
            }
        });

        rawButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.just_dance);
                mediaPlayer.start();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Inha", "Main Activity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Inha", "Main Activity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Inha", "Main Activity onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Inha", "Main Activity onDestroy");
    }

    @Override
    public void onClick(View view) {

    }
}