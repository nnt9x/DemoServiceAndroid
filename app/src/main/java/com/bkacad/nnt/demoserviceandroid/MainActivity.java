package com.bkacad.nnt.demoserviceandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStartService, btnStopService;
    private MyService myService;
    private MyReceiver myReceiver;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = findViewById(R.id.btnStartService);
        btnStopService = findViewById(R.id.btnStopService);

        // Sự kiện onClick
        btnStartService.setOnClickListener(this);
        btnStopService.setOnClickListener(this);

        // Khai báo Broadcast
        myReceiver = new MyReceiver() {
            @Override
            public void serviceStarted() {
                Toast.makeText(MainActivity.this, "Dịch vụ được chạy", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void serviceStopped() {
                Toast.makeText(MainActivity.this, "Dịch vụ đã dừng", Toast.LENGTH_SHORT).show();
            }
        };

        intentFilter = new IntentFilter();
        intentFilter.addAction("listen.MyService.started");
        intentFilter.addAction("listen.MyService.stopped");
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReceiver);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStartService:
                startService(new Intent(MainActivity.this, MyService.class));
                break;
            case R.id.btnStopService:
                // Xử lý sau
                stopService(new Intent(MainActivity.this, MyService.class));
                break;
        }
    }
}