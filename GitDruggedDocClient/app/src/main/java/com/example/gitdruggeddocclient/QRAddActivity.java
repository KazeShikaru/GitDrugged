package com.example.gitdruggeddocclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

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
}
