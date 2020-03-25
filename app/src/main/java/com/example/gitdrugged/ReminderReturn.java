package com.example.gitdrugged;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ReminderReturn extends AppCompatActivity {
    public int day;
    public String[] checklist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminderchecklist);

    }

    public void moveToCalender(View view){

        setContentView(R.layout.calender);

    }

    public void loadData(View view){

        try {
            InputStream inputStream = view.getContext().openFileInput("dateChecked.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";

                if ( (receiveString = bufferedReader.readLine()) != null ) {
                    checklist = receiveString.split(",");
                }

                inputStream.close();

            }
        }catch (Exception e){

        }

    }

    public void saveData(View view){

        String filename = "dateChecked.txt";
        String s2Write = "";
        for(String s: checklist){
            s2Write+=","+s;
        }
        s2Write = s2Write.substring(1);
        //test to see if input is digits
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(view.getContext().openFileOutput(filename, view.getContext().MODE_PRIVATE));
            outputStreamWriter.write(s2Write);
            outputStreamWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void loadCalender(){
        TextView txt1 = findViewById(R.id.rem_txt_cal_1);
        TextView txt2 = findViewById(R.id.rem_txt_cal_2);
        TextView txt3 = findViewById(R.id.rem_txt_cal_3);
        TextView txt4 = findViewById(R.id.rem_txt_cal_4);
        TextView txt5 = findViewById(R.id.rem_txt_cal_5);
        TextView txt6 = findViewById(R.id.rem_txt_cal_6);
        TextView txt7 = findViewById(R.id.rem_txt_cal_7);
        TextView txt8 = findViewById(R.id.rem_txt_cal_8);
        TextView txt9 = findViewById(R.id.rem_txt_cal_9);
        TextView txt10 = findViewById(R.id.rem_txt_cal_10);
        TextView txt11 = findViewById(R.id.rem_txt_cal_11);
        TextView txt12 = findViewById(R.id.rem_txt_cal_12);
        TextView txt13 = findViewById(R.id.rem_txt_cal_13);
        TextView txt14 = findViewById(R.id.rem_txt_cal_14);
        TextView txt15 = findViewById(R.id.rem_txt_cal_15);
        TextView txt16 = findViewById(R.id.rem_txt_cal_16);
        TextView txt17 = findViewById(R.id.rem_txt_cal_17);
        TextView txt18 = findViewById(R.id.rem_txt_cal_18);
        TextView txt19 = findViewById(R.id.rem_txt_cal_19);
        TextView txt20 = findViewById(R.id.rem_txt_cal_20);
        TextView txt21 = findViewById(R.id.rem_txt_cal_21);
        TextView txt22 = findViewById(R.id.rem_txt_cal_22);
        TextView txt23 = findViewById(R.id.rem_txt_cal_23);
        TextView txt24 = findViewById(R.id.rem_txt_cal_24);
        TextView txt25 = findViewById(R.id.rem_txt_cal_25);
        TextView txt26 = findViewById(R.id.rem_txt_cal_26);
        TextView txt27 = findViewById(R.id.rem_txt_cal_27);
        TextView txt28 = findViewById(R.id.rem_txt_cal_28);
        TextView txt29 = findViewById(R.id.rem_txt_cal_29);
        TextView txt30 = findViewById(R.id.rem_txt_cal_30);
        TextView txt31 = findViewById(R.id.rem_txt_cal_31);
        txt1.setText(checklist[0]);
        txt2.setText(checklist[1]);
        txt3.setText(checklist[2]);
        txt4.setText(checklist[3]);
        txt5.setText(checklist[4]);
        txt6.setText(checklist[5]);
        txt7.setText(checklist[6]);
        txt8.setText(checklist[7]);
        txt9.setText(checklist[8]);
        txt10.setText(checklist[9]);
        txt11.setText(checklist[10]);
        txt12.setText(checklist[11]);
        txt13.setText(checklist[12]);
        txt14.setText(checklist[13]);
        txt15.setText(checklist[14]);
        txt16.setText(checklist[15]);
        txt17.setText(checklist[16]);
        txt18.setText(checklist[17]);
        txt19.setText(checklist[18]);
        txt20.setText(checklist[19]);
        txt21.setText(checklist[20]);
        txt22.setText(checklist[21]);
        txt23.setText(checklist[22]);
        txt24.setText(checklist[23]);
        txt25.setText(checklist[24]);
        txt26.setText(checklist[25]);
        txt27.setText(checklist[26]);
        txt28.setText(checklist[27]);
        txt29.setText(checklist[28]);
        txt30.setText(checklist[29]);
        txt31.setText(checklist[30]);

    }

    public void checkCalender(boolean drugged, int date){
        if(drugged){
            checklist[date-1] = "★";
        }else{
            checklist[date-1] = "☆";
        }

    }
}
