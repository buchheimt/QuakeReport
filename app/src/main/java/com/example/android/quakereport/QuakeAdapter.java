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

/**
 * Created by buchh on 10/22/2017.
 */

public class QuakeAdapter extends ArrayAdapter<Quake> {

    public QuakeAdapter(Activity context, ArrayList<Quake> quakes) {
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
        Quake currentQuake = getItem(position);

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeView.setText(String.format(Locale.US, "%.1f", currentQuake.getMagnitude()));

        TextView locationView = (TextView) listItemView.findViewById(R.id.location);
        locationView.setText(currentQuake.getLocation());

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(currentQuake.getDate());


        return listItemView;
    }
}
