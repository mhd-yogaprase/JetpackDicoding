package com.dicoding.picodiploma.jetpackdicoding.ui.tv;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.dicoding.picodiploma.jetpackdicoding.data.source.CatalogueRepository;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Tv;
import com.dicoding.picodiploma.jetpackdicoding.utils.DataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TvViewModelTest {
    private TvViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private CatalogueRepository catalogueRepository;

    @Mock
    private Observer<List<Tv>> observer;

    @Before
    public void setUp(){
        viewModel = new TvViewModel(catalogueRepository);
    }

    @Test
    public void getTv(){
        ArrayList<Tv> dummyTv = DataDummy.generateDummyTv();
        MutableLiveData<List<Tv>> tvList = new MutableLiveData<>();
        tvList.setValue(dummyTv);

        when(catalogueRepository.getAllTv()).thenReturn(tvList);
        List<Tv> tv = viewModel.getTv().getValue();
        verify(catalogueRepository).getAllTv();

        viewModel.getTv().observeForever(observer);
        verify(observer).onChanged(dummyTv);
    }
}