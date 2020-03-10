package com.dicoding.picodiploma.jetpackdicoding.data.source.remote.response;


import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieResponse {
    @SerializedName("results")
    private ArrayList<Movie> movieResults = null;

    public MovieResponse() {
    }

    public ArrayList<Movie> getMovieResults(){
        return movieResults;
    }
}
