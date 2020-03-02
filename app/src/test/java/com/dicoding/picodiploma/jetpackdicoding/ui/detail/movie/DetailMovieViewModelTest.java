package com.dicoding.picodiploma.jetpackdicoding.ui.detail.movie;

import com.dicoding.picodiploma.jetpackdicoding.data.MovieEntity;
import com.dicoding.picodiploma.jetpackdicoding.utils.DataDummy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailMovieViewModelTest {

    private DetailMovieViewModel detailMovieViewModel;
    private MovieEntity dummyMovie = DataDummy.generateDummyMovie().get(0);
    private String movieId = dummyMovie.getId();

    @Before
    public void setUp() {
        detailMovieViewModel = new DetailMovieViewModel();
        detailMovieViewModel.setSelectedMovie(movieId);
    }

    @Test
    public void getDetailsMovie() {
        detailMovieViewModel.setSelectedMovie(dummyMovie.getId());
        MovieEntity movieEntity = detailMovieViewModel.getDetailsMovie();
        assertNotNull(movieEntity);
        assertEquals(dummyMovie.getId(), movieEntity.getId());
        assertEquals(dummyMovie.getTitle(), movieEntity.getTitle());
        assertEquals(dummyMovie.getReleaseDate(), movieEntity.getReleaseDate());
        assertEquals(dummyMovie.getRuntime(), movieEntity.getRuntime());
        assertEquals(dummyMovie.getGenre(), movieEntity.getGenre());
        assertEquals(dummyMovie.getOverview(), movieEntity.getOverview());
        assertEquals(dummyMovie.getOriginalLanguage(), movieEntity.getOriginalLanguage());
        assertEquals(dummyMovie.getPoster(), movieEntity.getPoster());
    }
}