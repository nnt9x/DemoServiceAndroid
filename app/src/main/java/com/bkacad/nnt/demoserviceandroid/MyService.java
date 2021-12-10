package com.bkacad.nnt.demoserviceandroid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }


    // Ctr + O

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Dịch vụ sẽ được chạy -> công việc cần thực hiện tại đây
        Log.d("My Service","Chạy Service");

        // Gửi broadcast đến Main Activity
//        sendBroadcast();
        Intent mIntent = new Intent();
        mIntent.setAction("listen.MyService.started");
        sendBroadcast(mIntent);
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Intent mIntent = new Intent();
        mIntent.setAction("listen.MyService.stopped");
        sendBroadcast(mIntent);
    }
}