package com.example.gitdrugged;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class ViewDrug extends AppCompatActivity {

    public int did = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_drug);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        did = bundle.getInt("did");


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

        DrugData toDisplay = null;
        if(inJson != null) {
            datas = gson.fromJson(inJson, listType);
            for(final DrugData data : datas) {
                if(data.did == did) {
                    toDisplay = data;
                    Collections.sort(toDisplay.times);
                }
            }
        }

        ((TextView)findViewById(R.id.drug_name)).setText(toDisplay.name);
        ((TextView)findViewById(R.id.drug_days_to_take)).setText(Integer.toString(toDisplay.days));
        ((TextView)findViewById(R.id.drug_freq)).setText(Integer.toString(toDisplay.frequency));
        ImageView imgView = findViewById(R.id.image_view);
        switch(toDisplay.imageID) {
            case 1:
                imgView.setImageResource(R.drawable.p1);
                break;
            case 2:
                imgView.setImageResource(R.drawable.p2);
                break;
            case 3:
                imgView.setImageResource(R.drawable.p3);
                break;
            case 4:
                imgView.setImageResource(R.drawable.p4);
                break;
            default:
                imgView.setImageResource(R.drawable.p0);
        }

        int timeMin = toDisplay.times.get(0);
        String time1 = timeMin/60 + ":" + timeMin%60;
        ((TextView)findViewById(R.id.time1)).setText(time1);

        for(int i = 2; i < toDisplay.times.size() + 1; i++) {
            LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout view = (LinearLayout) inflater.inflate(R.layout.dose_time2,null);
            TextView textview = (TextView)view.getChildAt(0);
            textview.setText("Dose " + i + " Time:");

            TextView time = (TextView)view.getChildAt(1);
            int timeInMin = toDisplay.times.get(i-1);
            String timeDisplay = timeInMin/60 + ":" + timeInMin%60;
            time.setText(timeDisplay);

            ((LinearLayout)findViewById(R.id.drug_dose_times)).addView(view);
        }

    }

    public void done(View v) {
        finish();
    }

}
