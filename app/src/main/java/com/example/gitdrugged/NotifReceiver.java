package com.example.gitdrugged;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotifReceiver extends BroadcastReceiver {
    public NotifReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intent1 = new Intent(context, NotifIntentService.class);
        context.startService(intent1);
    }
}
