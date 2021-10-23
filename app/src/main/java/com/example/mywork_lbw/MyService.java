package com.example.mywork_lbw;

import android.app.Service;
import android.content.Intent;
import android.icu.util.Measure;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private MediaPlayer mediaPlayer;
    private int[] music={
            R.raw.music1
    };


    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("service","service is onCreate");
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.music1);
        mediaPlayer.start();

    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        if(mediaPlayer!=null)
            mediaPlayer=null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        throw new UnsupportedOperationException("Not yet implemented");
    }
}