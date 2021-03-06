package me.aprizal.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyService extends Service {
    public static final String TAG = "MyService";

    public MyService() {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"Service dijalankan...");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            Log.d(TAG, "preAsync: Mulai.....");
            try {
                Thread.sleep(2000);
                Log.d(TAG, "postAsync: Selesai.....");
                stopSelf();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
