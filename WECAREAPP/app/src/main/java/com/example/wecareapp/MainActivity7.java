package com.example.wecareapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity7 extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        new Handler().postDelayed(new Runnable()
        {
            @Override public void run()
            {
                Intent homeIntent = new Intent(com.example.wecareapp.MainActivity7.this,MainActivity8.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);


    }
}