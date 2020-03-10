package com.dicoding.picodiploma.jetpackdicoding.data.source.remote.response;

import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Tv;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TvResponse {
    @SerializedName("results")
    private ArrayList<Tv> tvResults = null;

    public TvResponse() {
    }

    public ArrayList<Tv> getTvResults(){
        return tvResults;
    }
}
