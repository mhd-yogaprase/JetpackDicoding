package com.dicoding.picodiploma.jetpackdicoding.viewmodel;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.dicoding.picodiploma.jetpackdicoding.data.source.CatalogueRepository;
import com.dicoding.picodiploma.jetpackdicoding.di.Injection;
import com.dicoding.picodiploma.jetpackdicoding.ui.detail.movie.DetailMovieViewModel;
import com.dicoding.picodiploma.jetpackdicoding.ui.detail.tv.DetailTvViewModel;
import com.dicoding.picodiploma.jetpackdicoding.ui.movie.MovieViewModel;
import com.dicoding.picodiploma.jetpackdicoding.ui.tv.TvViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;
    private final CatalogueRepository mCatalogueRepository;

    private ViewModelFactory(CatalogueRepository catalogueRepository){
        mCatalogueRepository = catalogueRepository;
    }

    public static ViewModelFactory getInstance(){
        if (INSTANCE == null){
            synchronized (ViewModelFactory.class){
                if (INSTANCE == null){
                    INSTANCE = new ViewModelFactory(Injection.provideRepository());
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass){

        if (modelClass.isAssignableFrom(MovieViewModel.class)){
            return (T) new MovieViewModel(mCatalogueRepository);
        }else if (modelClass.isAssignableFrom(DetailMovieViewModel.class)){
            return (T) new DetailMovieViewModel(mCatalogueRepository);
        }else if(modelClass.isAssignableFrom(TvViewModel.class)){
            return (T) new TvViewModel(mCatalogueRepository);
        }else if (modelClass.isAssignableFrom(DetailTvViewModel.class)){
            return (T) new DetailTvViewModel(mCatalogueRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
