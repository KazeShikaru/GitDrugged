package com.example.gitdrugged;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CheckUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_user);
    }

    public void onBackClicked(android.view.View view) {
        Intent intent = new Intent(this, MainDoctorActivity.class);
        startActivity(intent);
    }
}
