package com.example.gitdrugged;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheckPatientActivity extends AppCompatActivity {
    public static int med = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_patient);
        if(MainActivity.pid.equals("123456")) {
            Button rem = (Button)findViewById(R.id.med3Button);
            rem.setVisibility(View.GONE);
            TextView txtvw =(TextView)findViewById(R.id.patientName);
            txtvw.setText("Rick A.'s Medicine List");
            txtvw =(TextView)findViewById(R.id.med1);
            txtvw.setText("Bicardine");
            txtvw =(TextView)findViewById(R.id.med2);
            txtvw.setText("Dexalin");
            txtvw =(TextView)findViewById(R.id.med3);
            txtvw.setText("");
        }
        else if(MainActivity.pid.equals("654321")) {
            TextView txtvw =(TextView)findViewById(R.id.patientName);
            txtvw.setText("Rick B.'s Medicine List");
            txtvw =(TextView)findViewById(R.id.med1);
            txtvw.setText("ImiAlky");
            txtvw =(TextView)findViewById(R.id.med2);
            txtvw.setText("Oxycodone");
            txtvw =(TextView)findViewById(R.id.med3);
            txtvw.setText("Tricordazine");
        }
        else if(MainActivity.pid.equals("481961")) {
            Button rem = (Button)findViewById(R.id.med3Button);
            rem.setVisibility(View.GONE);
            TextView txtvw =(TextView)findViewById(R.id.patientName);
            txtvw.setText("Rick Obama's Medicine List");
            txtvw =(TextView)findViewById(R.id.med1);
            txtvw.setText("Dylovene");
            txtvw =(TextView)findViewById(R.id.med2);
            txtvw.setText("Ethylredoxrazine");
            txtvw =(TextView)findViewById(R.id.med3);
            txtvw.setText("");
        }
    }

    public void onBackClicked(View view) {
        Intent intent = new Intent(this, ManagePatientActivity.class);
        startActivity(intent);
    }

    public void onMed1Clicked(View view) {
        med = 1;
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }
    public void onMed2Clicked(View view) {
        med = 2;
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }

    public void onMed3Clicked(View view) {
        med = 3;
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }
}
