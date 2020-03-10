package com.dicoding.picodiploma.jetpackdicoding.ui.detail.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.dicoding.picodiploma.jetpackdicoding.data.source.CatalogueRepository;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Movie;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.MovieDetail;
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
public class DetailMovieViewModelTest {
    private DetailMovieViewModel viewModel;
    private Movie dummyMovie = DataDummy.generateDummyMovie().get(0);
    private int movieId = dummyMovie.getId();
    private MovieDetail dummyDetail = DataDummy.generateDummyMovieDetail(movieId);

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private CatalogueRepository catalogueRepository;

    @Mock
    private Observer<MovieDetail> observer;

    @Before
    public void setUp(){
        viewModel = new DetailMovieViewModel(catalogueRepository);
        viewModel.setSelectedMovie(movieId);
    }

    @Test
    public void getMovieDetail(){
        MutableLiveData<MovieDetail> movieDetail = new MutableLiveData<>();
        movieDetail.setValue(dummyDetail);
        when(catalogueRepository.getMovieDetail(movieId)).thenReturn(movieDetail);
        MovieDetail detailEntities = viewModel.getDetailMovie().getValue();
        verify(catalogueRepository).getMovieDetail(movieId);

        assertNotNull(detailEntities);
        assertEquals(dummyDetail.getId(), detailEntities.getId());
        assertEquals(dummyDetail.getTitle(), detailEntities.getTitle());
        assertEquals(dummyDetail.getReleaseDate(), detailEntities.getReleaseDate());
        assertEquals(dummyDetail.getPosterPath(), detailEntities.getPosterPath());
        assertEquals(dummyDetail.getBackdropPath(), detailEntities.getBackdropPath());
        assertEquals(dummyDetail.getOverview(), detailEntities.getOverview());
        assertEquals(dummyDetail.getStatus(), detailEntities.getStatus());
        assertEquals(dummyDetail.getVoteCount(), detailEntities.getVoteCount());

        viewModel.getDetailMovie().observeForever(observer);
        verify(observer).onChanged(dummyDetail);
    }
}