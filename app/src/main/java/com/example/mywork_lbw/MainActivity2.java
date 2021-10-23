package com.example.mywork_lbw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
     Intent intent;
      private MyService2.Mybinder mybinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        Button button = findViewById(R.id.button);
        Button button3=findViewById(R.id.button3);
        Button button4=findViewById(R.id.button4);




        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceConnection connection=new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        MyService2.Mybinder mybinder= (MyService2.Mybinder) service;
                        mybinder.play();
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {
                        mybinder = null;
                    }
                };
                Intent main5=new Intent(MainActivity2.this,MyService2.class);
                bindService(main5,connection, Context.BIND_AUTO_CREATE);
            }
        });



        Log.d("life","activity2 is on create...");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main2 = new Intent(MainActivity2.this,MainActivity3.class);  // ****
               main2.putExtra("name","刘博闻");
               main2.putExtra("age",21);
                Toast.makeText(getApplicationContext(),"跳转页面",Toast.LENGTH_SHORT).show();
            startActivity(main2);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "启动", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "恢复", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "暂停", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "停止", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "重启", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "再见", Toast.LENGTH_SHORT).show();
    }
}
