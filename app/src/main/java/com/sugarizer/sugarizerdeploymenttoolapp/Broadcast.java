package com.sugarizer.sugarizerdeploymenttoolapp;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.WindowManager;


public class Broadcast extends BroadcastReceiver {
    private static final String TAG = Broadcast.class.getSimpleName();

    private static final int ID_NOTIFICATION_LOG = 1;

    public final static int REQUEST_CODE = 10000;

    public static final String INTENT = "extra_intent";

    public static final String ACTION_PING = "com.sugarizer.sugarizerdeploymentoolapp.Broadcast.ACTION_PING";
    public static final String ACTION_LOG = "com.sugarizer.sugarizerdeploymentoolapp.Broadcast.ACTION_LOG";
    public static final String ACTION_PROGRESS = "com.sugarizer.sugarizerdeploymentoolapp.Broadcast.ACTION_PROGRESS";
    public static final String ACTION_STOP = "com.sugarizer.sugarizerdeploymentoolapp.Broadcast.ACTION_STOP";

    public static final String EXTRA_LOG = "extra_log";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(Broadcast.class.getSimpleName(), "Je reçois quelque chose");
        Log.d(Broadcast.class.getSimpleName(), "" + intent.getAction());

        switch (intent.getAction()) {
            case ACTION_PING:
                context.startActivity(new Intent(context, PingActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                break;
            case ACTION_LOG:
                Log.d(TAG, "" + intent.getStringExtra(EXTRA_LOG));

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Sugarizer Deployment Tool")
                        .setContentText("" + intent.getStringExtra(EXTRA_LOG))
                        .setOngoing(true);

                NotificationCompat.Action stop = new NotificationCompat.Action.Builder(R.mipmap.ic_launcher, "Stop", PendingIntent.getBroadcast(context, 0, new Intent(ACTION_STOP), 0))
                        .build();

                mBuilder.addAction(stop);

                NotificationManagerCompat.from(context).notify(1, mBuilder.build());
                break;
            case ACTION_PROGRESS:
//                if (Settings.canDrawOverlays(context)) {
//                    android.app.AlertDialog dialog = new AlertDialog.Builder(context).create();
//                    dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
//                    dialog.setContentView(R.layout.dialog_progress);
//                    dialog.show();
//                } else {
//                    Intent tmp = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + context.getPackageName()));
//                    context.startActivity(tmp);
//                }
                break;
            case ACTION_STOP:
                NotificationManagerCompat.from(context).cancel(1);
                break;
        }
    }
}
