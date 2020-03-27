package com.example.gitdrugged;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SignUp extends AppCompatActivity {

    boolean t;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final Button signup = (Button) findViewById(R.id.signup);
        final EditText userName = (EditText) findViewById(R.id.username);
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText password = (EditText) findViewById(R.id.password);
        final EditText data = (EditText) findViewById(R.id.Data);
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                t = true;
                if (t) {
                    String id = readFromFile(getApplicationContext());
                    int id_int;
                    try{
                        id_int = Integer.parseInt(id);
                    }catch (Exception e){
                        id_int = 111111;
                    }
                    if (userName.getText().toString().isEmpty()) {
                        int duration = Toast.LENGTH_SHORT;
                        Context context = getApplicationContext();
                        Toast.makeText(context, "Invalid username", duration).show();
                        t = false;
                    }
                    if (name.getText().toString().isEmpty()) {
                        int duration = Toast.LENGTH_SHORT;
                        Context context = getApplicationContext();
                        Toast.makeText(context, "Invalid Name", duration).show();
                        t = false;
                    }
                    id_int++;
                    Intent intent = new Intent(SignUp.this, loginOrSignUp.class);
                    String message = userName.getText().toString()+ ", " + name.getText().toString()+ ", " + password.getText().toString() + ", "+id_int +", "+ data.getText().toString();
                    message += "\n";
                    writeToFile((id_int+""), getApplicationContext(), "ids.txt");
                    writeToFile(message, getApplicationContext(), "context.txt");
                    startActivity(intent);
                }
                t = true;
            }
        });
    }
    private void writeToFile(String data,Context context, String file) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(file, Context.MODE_APPEND));;
            if(file.equals("ids.txt")){
                outputStreamWriter = new OutputStreamWriter(context.openFileOutput(file, Context.MODE_PRIVATE));
            }
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
    private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("ids.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);

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
