package com.example.gitdrugged;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddDrug extends AppCompatActivity {

    public int freqCounter = 1;
    public int uid = 0;

    public HashMap<Integer,Integer> freqList = new HashMap<>();
    public HashMap<Integer,Integer> layoutList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_drug);

        final String[] DRUGNAMES = getResources().getStringArray(R.array.drug_names);

        AutoCompleteTextView name = findViewById(R.id.name);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DRUGNAMES);
        name.setAdapter(adapter);

        freqList.put(1,R.id.dose1);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        uid = bundle.getInt("uid");

        ArrayAdapter<CharSequence> spinAdapter = ArrayAdapter.createFromResource(this, R.array.image_spinner, android.R.layout.simple_spinner_item);
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner)findViewById(R.id.image_spinner)).setAdapter(spinAdapter);

    }

    public void freq_minus(View v) {
        if(freqCounter !=1) {
            LinearLayout parent = findViewById(R.id.dosage_times);
            parent.removeView(findViewById(layoutList.get(freqCounter)));
            freqList.remove(freqCounter);

            freqCounter--;
            TextView freq = findViewById(R.id.freq);
            freq.setText(freqCounter + "/day");
        }
    }

    public void freq_plus(View v) {
        freqCounter++;
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout view = (LinearLayout) inflater.inflate(R.layout.dose_time,null);
        TextView textview = (TextView)view.getChildAt(0);
        textview.setText("Dose " + freqCounter + " Time:");

        int layoutID = View.generateViewId();
        view.setId(layoutID);
        layoutList.put(freqCounter,layoutID);

        int timeID = View.generateViewId();
        TimePicker time = (TimePicker)view.getChildAt(1);
        time.setId(timeID);
        freqList.put(freqCounter,timeID);

        LinearLayout parent = findViewById(R.id.dosage_times);
        parent.addView(view);

        TextView freq = findViewById(R.id.freq);
        freq.setText(freqCounter + "/day");
    }

    public void done(View v) {
        String image = ((Spinner)findViewById(R.id.image_spinner)).getSelectedItem().toString();
        int imageID = 0;

        if(image.equals("anone")) {
            imageID = 3;
        }
        else {
            try {
                imageID = Integer.parseInt(image);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        String name = ((EditText)findViewById(R.id.name)).getText().toString();
        int days = 1; //defaults to 1 if parse fails
        try{
            days = Integer.parseInt(((EditText)findViewById(R.id.days_to_take)).getText().toString());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        int freq = freqCounter;

        ArrayList<Integer> times = new ArrayList<>(freqCounter);
        for(Map.Entry<Integer,Integer> entry : freqList.entrySet()) {
            int dose = entry.getKey();
            int id = entry.getValue();
            TimePicker timeView = (TimePicker)findViewById(id);
            int hour = timeView.getHour();
            int minute = timeView.getMinute();
            times.add((hour*60)+minute);
        }

        DrugData data = new DrugData();
        data.name = name;
        data.days = days;
        data.frequency = freq;
        data.times = times;
        data.uid = uid;
        data.imageID = imageID;

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
        }

        if(inJson == null) {
            datas = new ArrayList<DrugData>();
        }
        else {
            datas = gson.fromJson(inJson,listType);
        }

        data.did = datas.size();
        datas.add(data);
        String json = gson.toJson(datas);
        try {
            FileOutputStream out = openFileOutput(fileName,Context.MODE_PRIVATE);
            out.write(json.getBytes());
            out.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finish();
    }

    public void camera(View v) {
        //TODO
    }
}