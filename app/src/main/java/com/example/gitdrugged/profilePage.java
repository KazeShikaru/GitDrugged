package com.example.gitdrugged;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class profilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        final Button logout = (Button) findViewById(R.id.logout);
        final Button check = (Button) findViewById(R.id.checkDrugs);
        String id = getIntent().getStringExtra("id");
        String allInfo = readFromFile(getApplicationContext());
        String[] infoSplit = allInfo.split("/n");
        String userInfo="";
        for(int i = 0; i<infoSplit.length; i++){
            if(infoSplit[i].contains(id)) {
                userInfo = infoSplit[i];
                break;
            }
        }
        final String[] userInfoArray = userInfo.split(", ");
        TextView name = (TextView) findViewById(R.id.nameData1);
        TextView idtxt = (TextView) findViewById(R.id.idData1);
        name.setText(userInfoArray[1]);
        idtxt.setText(userInfoArray[3]);
        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent in = new Intent(profilePage.this, loginOrSignUp.class);
                startActivity(in);
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent in = new Intent(profilePage.this, YourDrugs.class);
                in.putExtra("id", userInfoArray[3]);
                startActivity(in);
            }
        });
    }
    private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("context.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("/n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }
}
