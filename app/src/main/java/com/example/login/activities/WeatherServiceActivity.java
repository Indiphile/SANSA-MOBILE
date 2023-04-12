package com.example.login.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.login.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class WeatherServiceActivity extends AppCompatActivity {

    EditText searchLocationEditText;
    ImageView searchImgBtn;
    TextView averageTemp;
    ImageView weatherConditionImg;
    TextView weatherConditionTxt;

    TextView results;

    TextView humidityTv;
    TextView windSpeed;


    LocationManager locationManager;
    int PERMISSION_CODE = 1;

    private final String url = "https://api.openweathermap.org/data/2.5/weather";
    private final String appid = "e5bbdd4f3fb3cd343613c33ed133f982";
    DecimalFormat df = new DecimalFormat("#.#");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_service);

        searchLocationEditText = findViewById(R.id.search_location_editxt);
        searchImgBtn = findViewById(R.id.search_imgv_btn);
        averageTemp = findViewById(R.id.average_temp_tv);
        weatherConditionImg = findViewById(R.id.condition_imgV1);
        weatherConditionTxt = findViewById(R.id.condition_tv);

        humidityTv = findViewById(R.id.humidity_tv);
        windSpeed = findViewById(R.id.wind_speed_tv);


        searchImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWeatherDetails();
            }
        });


    }

    public void getWeatherDetails() {
        String tempUrl = "";
        String city = searchLocationEditText.getText().toString().trim();
        //String country = etCountry.getText().toString().trim();
        if (city.equals("")) {
            results.setText("City field can not be empty!");
        } else {

            tempUrl = url + "?q=" + city + "&appid=" + appid;

            StringRequest stringRequest = new StringRequest(Request.Method.POST, tempUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        JSONArray jsonArray = jsonResponse.getJSONArray("weather");
                        JSONObject jsonObjectWeather = jsonArray.getJSONObject(0);
                        String description = jsonObjectWeather.getString("description");
                        String iconCondition = jsonObjectWeather.getString("icon");
                        String iconUrl = "https://openweathermap.org/img/w/" + iconCondition + ".png";

                        Object context = null;
                       // Picasso.with(context).load(iconUrl).into(weatherConditionImg);
                        Picasso.get().load(iconUrl).into(weatherConditionImg);

                        JSONObject jsonObjectMain = jsonResponse.getJSONObject("main");
                        double temp = jsonObjectMain.getDouble("temp") - 273.15;
                        //double feelsLike = jsonObjectMain.getDouble("feels_like") - 273.15;
                        //float pressure = jsonObjectMain.getInt("pressure");
                        int humidity = jsonObjectMain.getInt("humidity");
                        JSONObject jsonObjectWind = jsonResponse.getJSONObject("wind");
                        double wind = jsonObjectWind.getDouble("speed") * 3.6;
                        JSONObject jsonObjectClouds = jsonResponse.getJSONObject("clouds");
                        //String clouds = jsonObjectClouds.getString("all");
                        JSONObject jsonObjectSys = jsonResponse.getJSONObject("sys");
                        String countryName = jsonObjectSys.getString("country");
                        String cityName = jsonResponse.getString("name");

                        String tempFormatted = (df.format(temp));
                        averageTemp.setText(tempFormatted + "°C");

                        weatherConditionTxt.setText(description);

                        humidityTv.setText(humidity + "%");

                        String windFormatted = df.format(wind);
                        windSpeed.setText(windFormatted + " Km/h");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }
}