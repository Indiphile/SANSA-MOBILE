package com.example.login.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;

import com.example.login.R;


public class SplashActivity extends AppCompatActivity {
    public static int splash_screen = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler ms = new Handler();
        ms.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, WelcomeDashboardActivity .class);
                startActivity(intent);
                finish();
            }
        },splash_screen);

    }
}