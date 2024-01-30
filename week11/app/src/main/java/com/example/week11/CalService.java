package com.example.week11;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class CalService extends Service {
    public CalService() {
    }

    IMyAidlInterface.Stub mBinder = new IMyAidlInterface.Stub() {
        @Override
        public int getLCM(int a, int b) throws RemoteException {
            int i;
            for(i = 1; ; i++){
                if(i % a == 0 && i % b == 0){
                    return i;
                }
            }
        }

        @Override
        public boolean isPrime(int n) throws RemoteException {
            int i;
            for(i = 2; i < n; i++){
                if(n % i == 0){
                    return false;
                }
            }
            return true;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return mBinder;
    }
}