package com.bkacad.nnt.demoserviceandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class MyReceiver extends BroadcastReceiver {

    public abstract void serviceStarted();
    public abstract void serviceStopped();

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case "listen.MyService.started":
                serviceStarted();
                break;
            case "listen.MyService.stopped":
                serviceStopped();
                break;
        }
    }
}
