package com.dicoding.picodiploma.jetpackdicoding.ui.detail.tv;

import com.dicoding.picodiploma.jetpackdicoding.data.TvEntity;
import com.dicoding.picodiploma.jetpackdicoding.ui.tv.TvViewModel;
import com.dicoding.picodiploma.jetpackdicoding.utils.DataDummy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailTvViewModelTest {
    private DetailTvViewModel tvViewModel;
    private TvEntity dummyTv = DataDummy.generateDummyTv().get(0);
    private String tvId = dummyTv.getId();

    @Before
    public void setUp() {
        tvViewModel = new DetailTvViewModel();
        tvViewModel.setSelectedTv(tvId);
    }

    @Test
    public void getDetailsTv() {
        tvViewModel.setSelectedTv(dummyTv.getId());
        TvEntity tvEntity = tvViewModel.getDetailsTv();
        assertNotNull(tvEntity);
        assertEquals(dummyTv.getId(), tvEntity.getId());
        assertEquals(dummyTv.getName(), tvEntity.getName());
        assertEquals(dummyTv.getFirstAirDate(), tvEntity.getFirstAirDate());
        assertEquals(dummyTv.getRuntime(), tvEntity.getRuntime());
        assertEquals(dummyTv.getGenre(), tvEntity.getGenre());
        assertEquals(dummyTv.getOverview(), tvEntity.getOverview());
        assertEquals(dummyTv.getOriginalLanguage(), tvEntity.getOriginalLanguage());
        assertEquals(dummyTv.getPoster(), tvEntity.getPoster());
    }
}
