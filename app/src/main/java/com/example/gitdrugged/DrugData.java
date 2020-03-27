package com.example.gitdrugged;

import java.util.ArrayList;

public class DrugData {
    public int did;
    public int uid;
    public String name = "";
    public int days = 0; //days to take drug
    public int frequency = 0;
    public int imageID = 0;

//CUSTOM FREQUENCY
    public ArrayList<Integer> times = new ArrayList<>(); //time in minutes from midnight
}
