package com.example.mywork_lbw;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService2 extends Service {
    public MyService2() {
    }
    private MediaPlayer mediaPlayer;
    private int[] music={
            R.raw.music1
    };




    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("service","service is onStartCommand");


        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.music1);
        mediaPlayer.start();
        Log.d("service","service is onCreate");
        return super.onStartCommand(intent,flags,startId);

    }

    @Override
    public void onDestroy() {

        mediaPlayer.stop();
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }



    public IBinder onBind(Intent intent) {
        return new Mybinder();
    }

    protected class Mybinder extends Binder {
        public void play()
        {
            mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.music1);
            mediaPlayer.start();


        }



    }

}