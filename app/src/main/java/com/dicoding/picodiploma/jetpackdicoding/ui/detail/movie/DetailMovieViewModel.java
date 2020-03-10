package com.dicoding.picodiploma.jetpackdicoding.ui.detail.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.jetpackdicoding.data.source.CatalogueRepository;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.MovieDetail;

public class DetailMovieViewModel extends ViewModel {
    private int movieId;
    private CatalogueRepository catalogueRepository;

    public DetailMovieViewModel(CatalogueRepository mCatalogueRepository){
        this.catalogueRepository = mCatalogueRepository;
    }

    void setSelectedMovie(int movieId){
        this.movieId = movieId;
    }

    LiveData<MovieDetail> getDetailMovie(){
        return catalogueRepository.getMovieDetail(movieId);
    }
}
