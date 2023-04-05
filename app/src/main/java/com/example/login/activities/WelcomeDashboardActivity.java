package com.example.login.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.login.R;
import com.example.login.adapters.The_Slide_items_Pager_Adapter;
import com.example.login.model.The_Slide_Items_Model_Class;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class WelcomeDashboardActivity extends AppCompatActivity {

    private List<The_Slide_Items_Model_Class> listItems;
    private ViewPager page;
    private TabLayout tabLayout;

    Button loginBtn;
    ImageView weatherServiceImgVBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_dashboard);

        loginBtn = findViewById(R.id.welcome_login_btn);
        weatherServiceImgVBtn = findViewById(R.id.weather_imgV);

        page = findViewById(R.id.my_pager);
        tabLayout = findViewById(R.id.my_tablayout);

        // Make a copy of the slides you'll be presenting.
        listItems = new ArrayList<>();
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.slide1, ""));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.slide2, ""));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.slide3, ""));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.slide4, ""));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.slide5, ""));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.slide6, ""));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.slide7, ""));


        The_Slide_items_Pager_Adapter itemsPager_adapter = new The_Slide_items_Pager_Adapter(this, listItems);
        page.setAdapter(itemsPager_adapter);

        // The_slide_timer
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new The_slide_timer(), 2000, 3000);
        tabLayout.setupWithViewPager(page, true);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeDashboardActivity.this, LoginActivity.class));
            }
        });

        weatherServiceImgVBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeDashboardActivity.this, WeatherServiceActivity.class));
            }
        });
    }


    public class The_slide_timer extends TimerTask {
        @Override
        public void run() {

            WelcomeDashboardActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (page.getCurrentItem()< listItems.size()-1) {
                        page.setCurrentItem(page.getCurrentItem()+1);
                    }
                    else
                        page.setCurrentItem(0);
                }
            });
        }
    }


}