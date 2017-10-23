package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by buchh on 10/22/2017.
 */

public class QuakeAdapter extends ArrayAdapter<Earthquake> {

    public QuakeAdapter(Activity context, ArrayList<Earthquake> quakes) {
        super(context, 0, quakes);
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
        magnitudeView.setText(String.format(Locale.US, "%.1f", currentQuake.getMagnitude()));

        TextView locationView = (TextView) listItemView.findViewById(R.id.location);
        locationView.setText(currentQuake.getLocation());

        Date dateObject = new Date(currentQuake.getTimeInMilliseconds());

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(formatDate(dateObject));

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        timeView.setText(formatTime(dateObject));

        return listItemView;
    }

    public String formatDate(Date dateObject) {
        SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
        return format.format(dateObject);
    }

    public String formatTime(Date dateObject) {
        SimpleDateFormat format = new SimpleDateFormat("h:mm a");
        return format.format(dateObject);
    }
}
