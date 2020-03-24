package com.example.gitdrugged;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final String channel_name = "c1";
    public static final String channel_description = "Main Channel for Medical Notif Delivery";
    public static String notif1ID = "main";
    public NotificationChannel channel1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, notif1ID)
                .setSmallIcon(R.drawable.gitdruggedlogo)
                .setContentTitle("Medical Reminder")
                .setContentText("UWU")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

    }



    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = channel_name;
            String description = channel_description;
            int importance = NotificationManager.IMPORTANCE_HIGH;
            channel1 = new NotificationChannel(notif1ID, name, importance);
            channel1.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel1);

        }
    }
}
