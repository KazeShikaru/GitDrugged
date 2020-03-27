package com.example.gitdruggeddocclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class AddPatientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
    }

    public void onIDAddClicked(android.view.View view) {
        Intent intent = new Intent(this, IDAddActivity.class);
        startActivity(intent);
    }

    public void onQRAddClicked(android.view.View view) {
        Intent intent = new Intent(this, QRAddActivity.class);
        startActivity(intent);
    }

    public void onBackClicked(android.view.View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
