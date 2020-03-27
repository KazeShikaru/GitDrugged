package com.example.gitdrugged;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainDoctorActivity extends AppCompatActivity {
    public static String pid = "";
    public static boolean exist = false;
    public static ArrayList<UserObject> user = new ArrayList<UserObject>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_doc);
    }

    public void onAddClicked(android.view.View view) {
        Intent intent = new Intent(this, AddPatientActivity.class);
        startActivity(intent);
    }

    public void onManageClicked(android.view.View view) {
        Intent intent = new Intent(this, ManagePatientActivity.class);
        startActivity(intent);
    }

    public void onReturnClicked(android.view.View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onUserClicked(android.view.View view) {
        Intent intent = new Intent(this, CheckUserActivity.class);
        startActivity(intent);
    }

    public static void rick() {
        exist = true;
    }

    public static void rickrick() {
        exist = true;
    }

    public static void obama() {
        exist = true;
    }
}
