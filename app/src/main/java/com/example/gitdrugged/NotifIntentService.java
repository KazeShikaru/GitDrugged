package com.example.gitdrugged;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;

import androidx.core.app.JobIntentService;
import androidx.core.app.NotificationManagerCompat;

public class NotifIntentService extends JobIntentService {
    private static final int NOTIFICATION_ID = 3;

    public NotifIntentService() {

    }

    @Override
    protected void onHandleWork(Intent intent) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("My Title");
        builder.setContentText("This is the Body");
        builder.setSmallIcon(R.drawable.gdlogo);
        Intent notifyIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        //to be able to launch your activity from the notification
        builder.setContentIntent(pendingIntent);
        Notification notificationCompat = builder.build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(NOTIFICATION_ID, notificationCompat);
    }
}
