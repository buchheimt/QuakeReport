package com.example.android.quakereport;

/**
 * Created by buchh on 10/21/2017.
 */

public class Quake {

    private double mMagnitude;
    private String mLocation;
    private String mDate;

    public Quake(double mag, String location, String date) {
        mMagnitude = mag;
        mLocation = location;
        mDate = date;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDate() {
        return mDate;
    }
}
