package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private String uri;

    public EarthquakeLoader(Context context, String uri) {
        super(context);
        this.uri = uri;
    }

    @Nullable
    @Override
    public List<Earthquake> loadInBackground() {
        String json = QueryUtils.getSampleJsonResponse(uri);
        List<Earthquake> earthquakes = QueryUtils.extractEarthquakes(json);
        return earthquakes;
    }
}
