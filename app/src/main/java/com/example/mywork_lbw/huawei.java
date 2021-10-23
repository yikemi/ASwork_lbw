package com.example.mywork_lbw;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class huawei extends AppCompatActivity {
    public huawei() { }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huawei);
        Log.i("life ", "huawei is on create...");  //信息在LogCat控制台输出
        Intent intent = getIntent();
    }
}