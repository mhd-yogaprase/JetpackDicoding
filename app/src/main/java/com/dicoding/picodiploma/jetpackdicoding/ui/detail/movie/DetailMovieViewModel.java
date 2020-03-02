package com.dicoding.picodiploma.jetpackdicoding.ui.detail.movie;

import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.jetpackdicoding.data.MovieEntity;
import com.dicoding.picodiploma.jetpackdicoding.utils.DataDummy;

import java.util.ArrayList;

public class DetailMovieViewModel extends ViewModel {
    private String movieId;

    public void setSelectedMovie(String movieId){
        this.movieId = movieId;
    }

    public MovieEntity getDetailsMovie(){
        MovieEntity movie = null;
        ArrayList<MovieEntity> movieEntities = new ArrayList<>();
        movieEntities.addAll(DataDummy.generateDummyMovie());
        for (MovieEntity movieEntity : movieEntities){
            if (movieEntity.getId().equals(movieId)){
                movie = movieEntity;
            }
        }
        return movie;
    }
}
