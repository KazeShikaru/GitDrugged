package com.example.gitdruggeddocclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        if(CheckPatientActivity.med == 1) {
            TextView txtvw =(TextView)findViewById(R.id.drugCal);
            if(MainActivity.pid.equals("123456")){
                txtvw.setText("Bicardine - March 2020");
            }
            if(MainActivity.pid.equals("654321")){
                txtvw.setText("ImiAlky - March 2020");
            }
            if(MainActivity.pid.equals("481961")){
                txtvw.setText("Dylovene - March 2020");
            }
        }
        else if(CheckPatientActivity.med == 2) {
            TextView txtvw =(TextView)findViewById(R.id.drugCal);
            if(MainActivity.pid.equals("123456")){
                txtvw.setText("Dexalin - March 2020");
            }
            if(MainActivity.pid.equals("654321")){
                txtvw.setText("Oxycodone - March 2020");
            }
            if(MainActivity.pid.equals("481961")){
                txtvw.setText("Ethylredoxrazine - March 2020");
            }
        }
        else if(CheckPatientActivity.med == 3) {
            TextView txtvw =(TextView)findViewById(R.id.drugCal);
            txtvw.setText("Tricordazine - March 2020");
        }
    }

    public void onBackClicked(android.view.View view) {
        finish();
    }
}
