package com.example.gitdruggeddocclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ManagePatientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_patient);
        if(MainActivity.user.size() == 1) {
            Button rem = (Button)findViewById(R.id.pat1Button);
            rem.setVisibility(View.VISIBLE);
            TextView txtvw =(TextView)findViewById(R.id.pat1);
            txtvw.setText(MainActivity.user.get(0).name);
        }
        if(MainActivity.user.size() == 2) {
            Button rem = (Button)findViewById(R.id.pat1Button);
            rem.setVisibility(View.VISIBLE);
            rem = (Button)findViewById(R.id.pat2Button);
            rem.setVisibility(View.VISIBLE);
            TextView txtvw =(TextView)findViewById(R.id.pat1);
            txtvw.setText(MainActivity.user.get(0).name);
            txtvw =(TextView)findViewById(R.id.pat2);
            txtvw.setText(MainActivity.user.get(1).name);
        }
        if(MainActivity.user.size() == 3) {
            Button rem = (Button)findViewById(R.id.pat1Button);
            rem.setVisibility(View.VISIBLE);
            rem = (Button)findViewById(R.id.pat2Button);
            rem.setVisibility(View.VISIBLE);
            rem = (Button)findViewById(R.id.pat3Button);
            rem.setVisibility(View.VISIBLE);
            TextView txtvw =(TextView)findViewById(R.id.pat1);
            txtvw.setText(MainActivity.user.get(0).name);
            txtvw =(TextView)findViewById(R.id.pat2);
            txtvw.setText(MainActivity.user.get(1).name);
            txtvw =(TextView)findViewById(R.id.pat3);
            txtvw.setText(MainActivity.user.get(2).name);
        }

    }

    public void onBackClicked(android.view.View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onPat1Clicked(android.view.View view) {
            MainActivity.pid = MainActivity.user.get(0).userId;
            Intent intent = new Intent(this, CheckPatientActivity.class);
            startActivity(intent);
    }

    public void onPat2Clicked(android.view.View view) {
        MainActivity.pid = MainActivity.user.get(1).userId;
        Intent intent = new Intent(this, CheckPatientActivity.class);
        startActivity(intent);
    }

    public void onPat3Clicked(android.view.View view) {
        MainActivity.pid = MainActivity.user.get(2).userId;
        Intent intent = new Intent(this, CheckPatientActivity.class);
        startActivity(intent);
    }

}
