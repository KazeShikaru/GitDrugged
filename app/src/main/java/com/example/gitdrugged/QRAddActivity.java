package com.example.gitdrugged;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

public class QRAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qradd);
    }

    public void onBackClicked(android.view.View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onImageClicked(android.view.View view) {
        MainActivity.pid = "852456";
        Intent intent = new Intent(this, NewDoctorActivity.class);
        startActivity(intent);
    }
}
