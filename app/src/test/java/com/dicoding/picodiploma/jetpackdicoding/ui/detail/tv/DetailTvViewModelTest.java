package com.dicoding.picodiploma.jetpackdicoding.ui.detail.tv;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.dicoding.picodiploma.jetpackdicoding.data.source.CatalogueRepository;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Tv;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.TvDetail;
import com.dicoding.picodiploma.jetpackdicoding.utils.DataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailTvViewModelTest {
    private DetailTvViewModel viewModel;
    private Tv dummyTv = DataDummy.generateDummyTv().get(0);
    private int tvId = dummyTv.getId();
    private TvDetail dummyDetail = DataDummy.generateDummyTvDetail(tvId);

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private CatalogueRepository catalogueRepository;

    @Mock
    private Observer<TvDetail> observer;

    @Before
    public void setUp(){
        viewModel = new DetailTvViewModel(catalogueRepository);
        viewModel.setSelectedTv(tvId);
    }

    @Test
    public void getTvDetail() {
        MutableLiveData<TvDetail> tvDetail = new MutableLiveData<>();
        tvDetail.setValue(dummyDetail);
        when(catalogueRepository.getTvDetail(tvId)).thenReturn(tvDetail);
        TvDetail detailEntities = viewModel.getTvDetail().getValue();
        verify(catalogueRepository).getTvDetail(tvId);

        assertNotNull(detailEntities);
        assertEquals(dummyDetail.getId(), detailEntities.getId());
        assertEquals(dummyDetail.getName(), detailEntities.getName());
        assertEquals(dummyDetail.getFirstAirDate(), detailEntities.getFirstAirDate());
        assertEquals(dummyDetail.getPosterPath(), detailEntities.getPosterPath());
        assertEquals(dummyDetail.getBackdropPath(), detailEntities.getBackdropPath());
        assertEquals(dummyDetail.getOverview(), detailEntities.getOverview());
        assertEquals(dummyDetail.getStatus(), detailEntities.getStatus());
        assertEquals(dummyDetail.getVoteCount(), detailEntities.getVoteCount());

        viewModel.getTvDetail().observeForever(observer);
        verify(observer).onChanged(dummyDetail);
    }
}