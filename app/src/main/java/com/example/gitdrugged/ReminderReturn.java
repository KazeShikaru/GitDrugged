package com.example.gitdrugged;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReminderReturn extends AppCompatActivity {
    public int day;
    public int drugCount;
    public String[] checklist;
    public String[] defaultList ={"10","★","★","★","★","★","★","☆","★","★","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminderchecklist);


        loadData(this.findViewById(R.id.rem_chk1));
        //initSetup(this.findViewById(R.id.rem_chk1));
        day = Integer.parseInt(defaultList[0]);
        drugCount= 4;
        loadMeds();
    }

    public void initSetup(View view){
        checklist = defaultList.clone();
        saveData(view);
    }

    public void moveToCalender(View view){





        int drugsTakenCurrently=4;
        int drugsTaken = 0;
        CheckBox chk1 = findViewById(R.id.rem_chk1);
        if(chk1.isChecked()){drugsTaken++;};
        CheckBox chk2 = findViewById(R.id.rem_chk2);
        if(chk2.isChecked()){drugsTaken++;};
        CheckBox chk3 = findViewById(R.id.rem_chk3);
        if(chk3.isChecked()){drugsTaken++;};
        CheckBox chk4 = findViewById(R.id.rem_chk4);
        if(chk4.isChecked()){drugsTaken++;};
        System.out.print("got HEre");
        if(drugsTaken<drugsTakenCurrently){
            checkCalender(false,day);
        }else{
            checkCalender(true,day);
        }
        setContentView(R.layout.calender);
        loadCalender();
    }

    public void moveToMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

    public void loadMeds(){

        Gson gson = new Gson();
        List<DrugData> datas = null;
        String fileName = "drugs.json";
        String inJson = null;
        Type listType = new TypeToken<List<DrugData>>(){}.getType();
        try {
            InputStream in = openFileInput(fileName);
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            inJson = new String(buffer, "UTF-8");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            ((CheckBox) findViewById(R.id.rem_chk1)).setText("No Data");
            ((CheckBox) findViewById(R.id.rem_chk2)).setVisibility(View.INVISIBLE);
            ((CheckBox) findViewById(R.id.rem_chk3)).setVisibility(View.INVISIBLE);
            ((CheckBox) findViewById(R.id.rem_chk4)).setVisibility(View.INVISIBLE);
        }

        if(inJson != null) {
            datas = gson.fromJson(inJson, listType);
            int drugcount = datas.size();

            if(drugcount>0){
                ((CheckBox) findViewById(R.id.rem_chk1)).setText(datas.get(0).name);
                drugcount--;

            }
            if(drugcount>0){
                ((CheckBox) findViewById(R.id.rem_chk2)).setText(datas.get(1).name);
                drugcount--;

            }else{
                ((CheckBox) findViewById(R.id.rem_chk2)).setChecked(true);
                ((CheckBox) findViewById(R.id.rem_chk2)).setVisibility(View.INVISIBLE);
            }
            if(drugcount>0){
                ((CheckBox) findViewById(R.id.rem_chk3)).setText(datas.get(2).name);
                drugcount--;

            }else{
                ((CheckBox) findViewById(R.id.rem_chk3)).setChecked(true);
                ((CheckBox) findViewById(R.id.rem_chk3)).setVisibility(View.INVISIBLE);
            }
            if(drugcount>0){
                ((CheckBox) findViewById(R.id.rem_chk4)).setText(datas.get(3).name);
                drugcount--;

            }else{
                ((CheckBox) findViewById(R.id.rem_chk4)).setChecked(true);
                ((CheckBox) findViewById(R.id.rem_chk4)).setVisibility(View.INVISIBLE);
            }




        }


    };

    public void loadData(View view){

        try {
            InputStream inputStream = view.getContext().openFileInput("dateChecked.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";

                if ( (receiveString = bufferedReader.readLine()) != null ) {

                    receiveString= receiveString.substring(1);
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
        //s2Write = s2Write.substring(1);
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
        txt1.setText(checklist[1]);
        txt2.setText(checklist[2]);
        txt3.setText(checklist[3]);
        txt4.setText(checklist[4]);
        txt5.setText(checklist[5]);
        txt6.setText(checklist[6]);
        txt7.setText(checklist[7]);
        txt8.setText(checklist[8]);
        txt9.setText(checklist[9]);
        txt10.setText(checklist[10]);
        txt11.setText(checklist[11]);
        txt12.setText(checklist[12]);
        txt13.setText(checklist[13]);
        txt14.setText(checklist[14]);
        txt15.setText(checklist[15]);
        txt16.setText(checklist[16]);
        txt17.setText(checklist[17]);
        txt18.setText(checklist[18]);
        txt19.setText(checklist[19]);
        txt20.setText(checklist[20]);
        txt21.setText(checklist[21]);
        txt22.setText(checklist[22]);
        txt23.setText(checklist[23]);
        txt24.setText(checklist[24]);
        txt25.setText(checklist[25]);
        txt26.setText(checklist[26]);
        txt27.setText(checklist[27]);
        txt28.setText(checklist[28]);
        txt29.setText(checklist[29]);
        txt30.setText(checklist[30]);
        txt31.setText(checklist[31]);
        day = Integer.parseInt(checklist[0]);
    }

    public void checkCalender(boolean drugged, int date){
        if(drugged){
            checklist[date] = "★";
        }else{
            checklist[date] = "☆";
        }

    }
}
