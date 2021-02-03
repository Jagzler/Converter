package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToWeights(View v){
        startActivity(new Intent(MainActivity.this, Weights.class));
    }

    public void goToDistance(View v){
        startActivity(new Intent(MainActivity.this, Distance.class));
    }

    public void goToSpeeds(View v){
        startActivity(new Intent(MainActivity.this, Speeds.class));
    }

    public void goToVolumes(View v){
        startActivity(new Intent(MainActivity.this, Volumes.class));
    }

    public void goToTemperatures(View v){
        startActivity(new Intent(MainActivity.this, Temperatures.class));
    }


}