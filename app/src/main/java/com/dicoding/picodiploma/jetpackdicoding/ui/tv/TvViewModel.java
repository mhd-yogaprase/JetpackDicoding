package com.dicoding.picodiploma.jetpackdicoding.ui.tv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.jetpackdicoding.data.source.CatalogueRepository;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Tv;

import java.util.List;

public class TvViewModel extends ViewModel {
    private CatalogueRepository catalogueRepository;

    public TvViewModel(CatalogueRepository mCatalogueRepository){
        this.catalogueRepository = mCatalogueRepository;
    }

    public LiveData<List<Tv>> getTv(){
        return catalogueRepository.getAllTv();
    }
}
