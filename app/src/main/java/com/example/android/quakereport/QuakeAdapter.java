package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.DecimalFormat;
import android.graphics.drawable.GradientDrawable;

import java.util.ArrayList;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by buchh on 10/22/2017.
 */

public class QuakeAdapter extends ArrayAdapter<Earthquake> {

    private Context mContext;

    public QuakeAdapter(Activity context, ArrayList<Earthquake> quakes) {
        super(context, 0, quakes);
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,
                    parent, false);
        }
        Earthquake currentQuake = getItem(position);

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentQuake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);
        magnitudeView.setText(formatMagnitude(currentQuake.getMagnitude()));

        String locationOffset;
        String locationPrimary;
        String location = currentQuake.getLocation();
        if (location.contains(" of ")) {
            int locationSeperator = location.indexOf(" of ") + 3;
            locationOffset = location.substring(0, locationSeperator);
            locationPrimary = location.substring(locationSeperator);
        } else {
            locationOffset = "Near the";
            locationPrimary = location;
        }

        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);

        TextView locationPrimaryView = (TextView) listItemView.findViewById(R.id.location_primary);
        locationPrimaryView.setText(locationPrimary);

        Date dateObject = new Date(currentQuake.getTimeInMilliseconds());

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(formatDate(dateObject));

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        timeView.setText(formatTime(dateObject));

        return listItemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
        return format.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat format = new SimpleDateFormat("h:mm a");
        return format.format(dateObject);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magFormatter = new DecimalFormat("0.0");
        return magFormatter.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeInt = (int) Math.floor(magnitude);
        int magnitudeColorResourceId;
        switch (magnitudeInt) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
