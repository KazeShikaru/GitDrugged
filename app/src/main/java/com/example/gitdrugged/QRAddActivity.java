package com.example.gitdrugged;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class QRAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qradd);
    }

    public void onBackClicked(android.view.View view) {
        Intent intent = new Intent(this, AddPatientActivity.class);
        startActivity(intent);
    }

    public void onImageClicked(android.view.View view) {
        MainActivity.pid = "123456";
        Intent intent = new Intent(this, NewPatientActivity.class);
        startActivity(intent);
    }
}
