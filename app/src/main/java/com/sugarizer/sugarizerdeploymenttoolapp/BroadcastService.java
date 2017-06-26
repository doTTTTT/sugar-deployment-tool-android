package com.sugarizer.sugarizerdeploymenttoolapp;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class BroadcastService extends Service {
    private static final String TAG = BroadcastService.class.getSimpleName();

    public static final String EXTRA_INTENT = "intent_sugarizer";

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Started");

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("LISTENBROADCAST", "YEPPPPPPP");
            }
        };

        registerReceiver(receiver, new IntentFilter(EXTRA_INTENT));

        return super.onStartCommand(intent, flags, startId);
    }
}
