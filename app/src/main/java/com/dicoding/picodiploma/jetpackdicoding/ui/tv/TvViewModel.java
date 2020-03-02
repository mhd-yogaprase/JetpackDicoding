package com.dicoding.picodiploma.jetpackdicoding.ui.tv;

import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.jetpackdicoding.data.TvEntity;
import com.dicoding.picodiploma.jetpackdicoding.utils.DataDummy;

import java.util.List;

public class TvViewModel extends ViewModel {

    public List<TvEntity> getTv(){
        return DataDummy.generateDummyTv();
    }
}
