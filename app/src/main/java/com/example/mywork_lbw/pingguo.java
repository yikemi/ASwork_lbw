package com.example.mywork_lbw;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class pingguo extends AppCompatActivity {
    public pingguo() { }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pingguo);
        Log.i("life ", "pingguo is on create...");  //信息在LogCat控制台输出
        Intent intent=getIntent();
    }

}