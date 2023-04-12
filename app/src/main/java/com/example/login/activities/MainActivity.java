package com.example.login.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.login.R;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView farmName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        farmName = findViewById(R.id.farm_name_tv);

        Intent intent = getIntent();
        String getFarmName = intent.getStringExtra("farm");
        //Set Text
        farmName.setText(getFarmName);
    }
}