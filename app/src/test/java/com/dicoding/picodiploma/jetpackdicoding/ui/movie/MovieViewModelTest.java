package com.dicoding.picodiploma.jetpackdicoding.ui.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.dicoding.picodiploma.jetpackdicoding.data.source.CatalogueRepository;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Movie;
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
public class MovieViewModelTest {
    private MovieViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private CatalogueRepository catalogueRepository;

    @Mock
    private Observer<List<Movie>> observer;

    @Before
    public void setUp(){
        viewModel = new MovieViewModel(catalogueRepository);
    }

    @Test
    public void getMovie(){
        ArrayList<Movie> dummyMovie = DataDummy.generateDummyMovie();
        MutableLiveData<List<Movie>> movieList = new MutableLiveData<>();
        movieList.setValue(dummyMovie);

        when(catalogueRepository.getAllMovie()).thenReturn(movieList);
        List<Movie> movie = viewModel.getMovies().getValue();
        verify(catalogueRepository).getAllMovie();

        viewModel.getMovies().observeForever(observer);
        verify(observer).onChanged(dummyMovie);
    }

}