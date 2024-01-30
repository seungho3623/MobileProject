package com.example.week11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /*
    BroadcastReceiver wifiStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);
            if(wifiState == WifiManager.WIFI_STATE_ENABLED){
                Toast.makeText(context, "WIFI_STATE_ENABLED", Toast.LENGTH_SHORT).show();
            }else if(wifiState == WifiManager.WIFI_STATE_DISABLED){
                Toast.makeText(context, "WIFI_STATE_DISABLED", Toast.LENGTH_SHORT).show();
            }
        }
    };
    */
    /*
    Button startBtn;
    Button stopBtn;
    */
    EditText etA, etB, etN;
    Button buttonLCN, buttonPrime;
    IMyAidlInterface mCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        startBtn = (Button) findViewById(R.id.start);
        stopBtn = (Button) findViewById(R.id.stop);
        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        */
        etA = (EditText) findViewById(R.id.etA);
        etB = (EditText) findViewById(R.id.etB);
        etN = (EditText) findViewById(R.id.etN);
        buttonLCN = (Button) findViewById(R.id.buttonLCM);
        buttonPrime = (Button) findViewById(R.id.buttonPrime);
        buttonLCN.setOnClickListener(this);
        buttonPrime.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonLCM){
            int LCM = 0;
            try {
                LCM = mCal.getLCM(Integer.parseInt(etA.getText().toString()), Integer.parseInt(etB.getText().toString()));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            Toast.makeText(this, "LCM = " + LCM, Toast.LENGTH_SHORT).show();
        }else{
            //prime
            boolean bool;
            try {
                bool = mCal.isPrime(Integer.parseInt(etN.getText().toString()));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            Toast.makeText(this, "Prime = " + bool, Toast.LENGTH_SHORT).show();
        }
        /*
        if(view.getId() == R.id.start){
            startService(new Intent(this, MyService.class));
        }else{
            //stop
            stopService(new Intent(this, MyService.class));
        }
        */
    }

    ServiceConnection srvConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mCal = IMyAidlInterface.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mCal = null;
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent("com.inha.AIDL_EXAMPLE");
        intent.setPackage("com.example.week11");
        bindService(intent, srvConn, BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(srvConn);
    }
}