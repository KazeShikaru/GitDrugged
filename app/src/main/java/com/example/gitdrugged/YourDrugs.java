package com.example.gitdrugged;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class YourDrugs extends AppCompatActivity {

    public int uid = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_drugs);
    }

    protected  void onResume() {
        super.onResume();
        ViewGroup list = findViewById(R.id.drug_list);
        list.removeAllViews();


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

        if(inJson != null) {
            datas = gson.fromJson(inJson, listType);
            for(final DrugData data : datas) {
                if(data.uid != uid)
                    break;

                TextView view = new TextView(this);
                final float scale = this.getResources().getDisplayMetrics().density; //get dp scale
                int pixels = (int) (80 * scale + 0.5f);

                view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,pixels));
                view.setText(data.name);
                view.setTextSize(40);
                view.setPadding(20,0,0,0);
                view.setGravity(Gravity.CENTER_VERTICAL);
                view.setBackground(getDrawable(R.drawable.back_rec_black));
                view.setClickable(true);
                view.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        viewDrug(data.did);
                    }
                });
                list.addView(view);
            }
        }
    }

    public void addDrug(View v) {
        Intent intent = new Intent(this, AddDrug.class);
        intent.putExtra("uid", uid);
        startActivity(intent);
    }

    public void viewDrug(int drugID) {
        Intent intent = new Intent(this,ViewDrug.class);
        intent.putExtra("did",drugID);
        startActivity(intent);
    }

}
