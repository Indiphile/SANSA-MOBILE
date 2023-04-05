package com.example.login.model;

public class Farms {

    public Farms(String farmName, String farmLocation, int farmImg) {
        this.farmName = farmName;
        this.farmLocation = farmLocation;
        this.farmImg = farmImg;
    }

    String farmName,farmLocation;
    int farmImg;


    public String getFarmName() {
        return farmName;
    }

    public String getFarmLocation() {
        return farmLocation;
    }

    public int getFarmImg() {
        return farmImg;
    }
}

