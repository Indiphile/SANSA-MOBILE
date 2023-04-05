package com.example.login.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.login.R;
import com.example.login.adapters.RecyclerViewAdaptor;
import com.example.login.model.Farms;

import java.util.ArrayList;
import java.util.List;

public class AddFarmActivity extends AppCompatActivity {

    private TextView searchFarm;
    private Button addFarm;

    RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_farm);

        searchFarm = findViewById(R.id.farmNameSearch_txt);
        addFarm = findViewById(R.id.addFarm_btn);
        rv = findViewById(R.id.listFarms_recyclerView);

        List<Farms> farms = new ArrayList<Farms>();

        farms.add(new Farms("EC Farm","soweto",R.drawable.farm));
        farms.add(new Farms("Pretoria Farm","soweto",R.drawable.farm));
        farms.add(new Farms("Jozi Farm","soweto",R.drawable.farm));
        farms.add(new Farms("Alice wick","soweto",R.drawable.farm));


        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new RecyclerViewAdaptor(getApplicationContext(),farms));


    }
}