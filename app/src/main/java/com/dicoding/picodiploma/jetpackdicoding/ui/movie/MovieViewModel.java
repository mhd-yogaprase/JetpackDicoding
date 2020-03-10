package com.dicoding.picodiploma.jetpackdicoding.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.dicoding.picodiploma.jetpackdicoding.data.source.CatalogueRepository;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Movie;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private CatalogueRepository catalogueRepository;

    public MovieViewModel(CatalogueRepository mCatalogueRepository){
        this.catalogueRepository = mCatalogueRepository;
    }

    LiveData<List<Movie>> getMovies(){
        return catalogueRepository.getAllMovie();
    }
}
