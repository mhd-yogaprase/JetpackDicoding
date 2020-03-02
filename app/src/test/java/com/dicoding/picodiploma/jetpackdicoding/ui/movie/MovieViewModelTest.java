package com.dicoding.picodiploma.jetpackdicoding.ui.movie;

import com.dicoding.picodiploma.jetpackdicoding.data.MovieEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovieViewModelTest {
    private MovieViewModel movieViewModel;

    @Before
    public void setUp(){
        movieViewModel = new MovieViewModel();
    }

    @Test
    public void getMovies() {
        List<MovieEntity> movieEntities = movieViewModel.getMovies();
        assertNotNull(movieEntities);
        assertEquals(10, movieEntities.size());
    }
}