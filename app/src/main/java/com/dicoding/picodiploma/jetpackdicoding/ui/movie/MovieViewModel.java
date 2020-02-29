package com.dicoding.picodiploma.jetpackdicoding.ui.movie;

import androidx.lifecycle.ViewModel;


import com.dicoding.picodiploma.jetpackdicoding.data.MovieEntity;
import com.dicoding.picodiploma.jetpackdicoding.utils.DataDummy;

import java.util.List;

public class MovieViewModel extends ViewModel {

    public List<MovieEntity> getMovies(){
        return DataDummy.generateDummyMovie();
    }
}
