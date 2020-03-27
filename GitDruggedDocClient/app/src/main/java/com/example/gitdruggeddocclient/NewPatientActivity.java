package com.example.gitdruggeddocclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NewPatientActivity extends AppCompatActivity {
    public boolean exists = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_patient);
        if(MainActivity.pid.equals("123456")) {
            TextView txtvw =(TextView)findViewById(R.id.nameData);
            txtvw.setText("Rick A.");
            txtvw =(TextView)findViewById(R.id.idData);
            txtvw.setText("123456");
            MainActivity.user.add(new UserObject("Rick A.", "123456"));
            exists = true;
            MainActivity.rick();
        }
        else if(MainActivity.pid.equals("654321")) {
            TextView txtvw =(TextView)findViewById(R.id.nameData);
            txtvw.setText("Rick B.");
            txtvw =(TextView)findViewById(R.id.idData);
            txtvw.setText("654321");
            MainActivity.user.add(new UserObject("Rick B.", "654321"));
            exists = true;
            MainActivity.rickrick();
        }
        else if(MainActivity.pid.equals("481961")) {
            TextView txtvw =(TextView)findViewById(R.id.nameData);
            txtvw.setText("Rick Obama");
            txtvw =(TextView)findViewById(R.id.idData);
            txtvw.setText("481961");
            MainActivity.user.add(new UserObject("Rick Obama", "481961"));
            exists = true;
            MainActivity.obama();
        }
        else {
            TextView txtvw =(TextView)findViewById(R.id.nameData);
            txtvw.setText("Not Found");
            txtvw =(TextView)findViewById(R.id.idData);
            txtvw.setText("Not Found");
            txtvw =(TextView)findViewById(R.id.status);
            txtvw.setText("Patient Not Found");
            exists = false;
        }
    }

    public void onBackClicked(android.view.View view) {
        Intent intent = new Intent(this, AddPatientActivity.class);
        startActivity(intent);
    }

    public void onCheckClicked(android.view.View view) {
        if(exists) {
            Intent intent = new Intent(this, CheckPatientActivity.class);
            startActivity(intent);
        }
    }

    public void onRemoveClicked(android.view.View view) {
//        if(exists) {
//            Intent intent = new Intent(this, RemovePatientActivity.class);
//            startActivity(intent);
//        }
    }
}
