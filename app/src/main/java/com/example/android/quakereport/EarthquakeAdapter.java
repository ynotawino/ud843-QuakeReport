package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter {
    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.earthquake_item, parent, false);
            viewHolder.magnitude = convertView.findViewById(R.id.text_magnitude);
            viewHolder.locationOffset = convertView.findViewById(R.id.text_location_offset);
            viewHolder.primaryLocation = convertView.findViewById(R.id.text_primary_location);
            viewHolder.date = convertView.findViewById(R.id.text_date);
            viewHolder.time = convertView.findViewById(R.id.text_time);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        Earthquake earthquake = (Earthquake) getItem(position);
        viewHolder.magnitude.setText(new DecimalFormat("0.0").format(earthquake.getMag()));
        viewHolder.date.setText(earthquake.getDate());
        String primaryLocation, locationOffset;
        if (earthquake.getLocation().contains("of")) {
            locationOffset = earthquake.getLocation().substring(0, earthquake.getLocation().indexOf("of") + 2);
            primaryLocation = earthquake.getLocation().substring(earthquake.getLocation().indexOf("of") + 2, earthquake.getLocation().length());
            primaryLocation = primaryLocation.trim();
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = earthquake.getLocation();
        }
        viewHolder.locationOffset.setText(locationOffset);
        viewHolder.primaryLocation.setText(primaryLocation);
        viewHolder.time.setText(earthquake.getTime());
        GradientDrawable magnitudeCircle = (GradientDrawable) viewHolder.magnitude.getBackground();
        int magnitudeColorResourceId;
        switch ((int) Math.floor(earthquake.getMag())) {
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
                break;
        }
        magnitudeCircle.setColor(getContext().getColor(magnitudeColorResourceId));
        return convertView;
    }

    static class ViewHolder {
        TextView magnitude;
        TextView locationOffset;
        TextView primaryLocation;
        TextView date;
        TextView time;
    }
}
