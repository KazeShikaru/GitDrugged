package com.example.gitdruggeddocclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String pid = "";
    public static boolean exist = false;
    public static ArrayList<UserObject> user = new ArrayList<UserObject>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAddClicked(android.view.View view) {
        Intent intent = new Intent(this, AddPatientActivity.class);
        startActivity(intent);
    }

    public void onManageClicked(android.view.View view) {
        Intent intent = new Intent(this, ManagePatientActivity.class);
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
