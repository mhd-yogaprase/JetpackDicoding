package com.dicoding.picodiploma.jetpackdicoding.ui.detail.tv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.jetpackdicoding.data.source.CatalogueRepository;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.TvDetail;

public class DetailTvViewModel extends ViewModel {
    private int tvId;
    private CatalogueRepository catalogueRepository;

    public DetailTvViewModel(CatalogueRepository mCatalogueRepository) {
        this.catalogueRepository = mCatalogueRepository;
    }

    void setSelectedTv(int tvId) {
        this.tvId = tvId;
    }

    LiveData<TvDetail> getTvDetail(){
        return catalogueRepository.getTvDetail(tvId);
    }

}
