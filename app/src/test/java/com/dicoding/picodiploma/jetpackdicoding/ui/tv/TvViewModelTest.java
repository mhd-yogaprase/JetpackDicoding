package com.dicoding.picodiploma.jetpackdicoding.ui.tv;

import com.dicoding.picodiploma.jetpackdicoding.data.MovieEntity;
import com.dicoding.picodiploma.jetpackdicoding.data.TvEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TvViewModelTest {
    private TvViewModel tvViewModel;

    @Before
    public void setUp(){
        tvViewModel = new TvViewModel();
    }

    @Test
    public void getTv() {
        List<TvEntity> tvEntities = tvViewModel.getTv();
        assertNotNull(tvEntities);
        assertEquals(10, tvEntities.size());
    }
}