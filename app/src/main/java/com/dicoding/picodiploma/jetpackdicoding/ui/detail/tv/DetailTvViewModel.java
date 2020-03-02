package com.dicoding.picodiploma.jetpackdicoding.ui.detail.tv;

import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.jetpackdicoding.data.TvEntity;
import com.dicoding.picodiploma.jetpackdicoding.utils.DataDummy;

import java.util.ArrayList;

public class DetailTvViewModel extends ViewModel {
    private String tvId;

    public void setSelectedTv(String tvId){
        this.tvId = tvId;
    }

    public TvEntity getDetailsTv() {
        TvEntity tv = null;
        ArrayList<TvEntity> tvEntities = new ArrayList<>();
        tvEntities.addAll(DataDummy.generateDummyTv());
        for (TvEntity tvEntity : tvEntities) {
            if (tvEntity.getId().equals(tvId)){
                tv = tvEntity;
            }
        }
        return tv;
    }
}
