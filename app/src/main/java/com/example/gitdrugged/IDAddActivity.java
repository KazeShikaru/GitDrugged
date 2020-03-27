package com.example.gitdrugged;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class IDAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idadd);
    }

    public void onBackClicked(android.view.View view) {
        Intent intent = new Intent(this, AddPatientActivity.class);
        startActivity(intent);
    }

    public void onAddClicked(android.view.View view) {
        EditText getData = (EditText)findViewById(R.id.pidField);
        MainActivity.pid = getData.getText().toString();
        Intent intent = new Intent(this, NewPatientActivity.class);
        startActivity(intent);
    }

}
