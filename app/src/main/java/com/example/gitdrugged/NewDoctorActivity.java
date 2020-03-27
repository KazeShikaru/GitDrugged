package com.example.gitdrugged;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NewDoctorActivity extends AppCompatActivity {
    public boolean exists = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_doctor);
        if(MainActivity.pid.equals("852456")) {
            TextView txtvw =(TextView)findViewById(R.id.nameData);
            txtvw.setText("John Obama");
            txtvw =(TextView)findViewById(R.id.idData);
            txtvw.setText("852456");
            MainActivity.user.add(new UserObject("John Obama", "852456"));
            exists = true;
        }
//        else if(MainActivity.pid.equals("654321")) {
//            TextView txtvw =(TextView)findViewById(R.id.nameData);
//            txtvw.setText("Rick B.");
//            txtvw =(TextView)findViewById(R.id.idData);
//            txtvw.setText("654321");
//            MainActivity.user.add(new UserObject("Rick B.", "654321"));
//            exists = true;
//        }
//        else if(MainActivity.pid.equals("481961")) {
//            TextView txtvw =(TextView)findViewById(R.id.nameData);
//            txtvw.setText("Rick Obama");
//            txtvw =(TextView)findViewById(R.id.idData);
//            txtvw.setText("481961");
//            MainActivity.user.add(new UserObject("Rick Obama", "481961"));
//            exists = true;
//        }
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

    public void onBackClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
