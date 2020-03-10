package com.dicoding.picodiploma.jetpackdicoding.data.source;

import androidx.lifecycle.LiveData;


import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Movie;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.MovieDetail;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Tv;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.TvDetail;

import java.util.List;

public interface CatalogueDataSource {

    LiveData<List<Movie>> getAllMovie();

    LiveData<MovieDetail> getMovieDetail(int movieId);

    LiveData<List<Tv>> getAllTv();

    LiveData<TvDetail> getTvDetail(int tvId);

}

