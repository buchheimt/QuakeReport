package com.example.android.quakereport;

import java.net.URL;

/**
 * Created by buchh on 10/21/2017.
 */

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;
    private String mLink;

    public Earthquake(double mag, String location, long timeInMilliseconds, String link) {
        mMagnitude = mag;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mLink = link;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public String getLink() {
        return mLink;
    }
}
