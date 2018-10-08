package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Earthquake {
    private double mag;
    private String location;
    private String date;
    private String website;

    public Earthquake(double mag, String location, String date, String website) {
        this.mag = mag;
        this.location = location;
        this.date = date;
        this.website = website;
    }

    public String getDate() {
        Date formatDate = new Date(Long.valueOf(date));
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM DD, YYYY");
        return dateFormat.format(formatDate);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        Date formatDate = new Date(Long.valueOf(date));
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:MM a");
        return timeFormat.format(formatDate);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getMag() {
        return mag;
    }

    public void setMag(double mag) {
        this.mag = mag;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
