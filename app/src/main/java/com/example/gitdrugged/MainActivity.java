package com.example.gitdrugged;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.gitdrugged.App.CHANNEL_1_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);


    }

    public void sendOnChannel1(View v) {
        String title = "Git Drugged reminder";
        String message = "Let's do drugs now!";

        Intent activityIntent = new Intent(this, ReminderReturn.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0, activityIntent, 0);
        Intent broadcastIntent = new Intent(this, NotifReceiver.class);
        broadcastIntent.putExtra("toastMessage", message);
        PendingIntent actionIntent = PendingIntent.getBroadcast(this,
                0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.gitdruggedlogo)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.parseColor("#FFA31A"))
                .setContentIntent(contentIntent)
                .addAction(R.drawable.gdlogo,"Toast",actionIntent)
                .setAutoCancel(true)
                .build();

        notificationManager.notify(1, notification);

    }


    public String getData(){

        return "drug1,d,14,drug2,w,2";

    }


}
