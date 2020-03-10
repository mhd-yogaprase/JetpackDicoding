package com.dicoding.picodiploma.jetpackdicoding.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.RemoteDataSource;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Movie;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.MovieDetail;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Tv;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.TvDetail;
import com.dicoding.picodiploma.jetpackdicoding.utils.DataDummy;
import com.dicoding.picodiploma.jetpackdicoding.utils.LiveDataTestUtil;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CatalogueRepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RemoteDataSource remote = mock(RemoteDataSource.class);
    private FakeCatalogueRepository catalogueRepository = new FakeCatalogueRepository(remote);

    private ArrayList<Movie> movie = DataDummy.generateDummyMovie();
    private int movieId = movie.get(0).getId();
    private ArrayList<Tv> tv = DataDummy.generateDummyTv();
    private int tvId = tv.get(0).getId();

    private MovieDetail movieDetail = DataDummy.generateDummyMovieDetail(movieId);
    private TvDetail tvDetail = DataDummy.generateDummyTvDetail(tvId);


    @Test
    public void getAllMovie(){
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadMovieCallback) invocation.getArguments()[0])
                    .onAllMovieReceived(movie);
            return null;
        }).when(remote).getAllMovie(any(RemoteDataSource.LoadMovieCallback.class));
        List<Movie> movieEntities = LiveDataTestUtil.getValue(catalogueRepository.getAllMovie());
        verify(remote).getAllMovie(any(RemoteDataSource.LoadMovieCallback.class));

        assertNotNull(movieEntities);
        assertEquals(movie.size(), movieEntities.size());
    }

    @Test
    public void getAllTv(){
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadTvCallback) invocation.getArguments()[0]).onAllTvReceived(tv);
            return null;
        }).when(remote).getAllTv(any(RemoteDataSource.LoadTvCallback.class));
        List<Tv> tvEntities = LiveDataTestUtil.getValue(catalogueRepository.getAllTv());
        verify(remote).getAllTv(any(RemoteDataSource.LoadTvCallback.class));

        assertNotNull(tvEntities);
        assertEquals(tv.size(), tvEntities.size());
    }

    @Test
    public void getMovieDetail(){
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadMovieDetailCallback) invocation.getArguments()[1]).onMovieDetailReceived(movieDetail);
            return null;
        }).when(remote).getMovieDetail(eq(movieId), any(RemoteDataSource.LoadMovieDetailCallback.class));

        MovieDetail movieDetailEntities = LiveDataTestUtil.getValue(catalogueRepository.getMovieDetail(movieId));
        verify(remote).getMovieDetail(eq(movieId), any(RemoteDataSource.LoadMovieDetailCallback.class));

        assertNotNull(movieDetailEntities);
        assertEquals(movieDetail.getId(), movieDetailEntities.getId());
    }

    @Test
    public void getTvDetail(){
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadTvDetailCallback) invocation.getArguments()[1]).onTvDetailReceived(tvDetail);
            return null;
        }).when(remote).getTvDetail(eq(tvId), any(RemoteDataSource.LoadTvDetailCallback.class));
        TvDetail tvDetailEntities = LiveDataTestUtil.getValue(catalogueRepository.getTvDetail(tvId));
        verify(remote).getTvDetail(eq(tvId), any(RemoteDataSource.LoadTvDetailCallback.class));

        assertNotNull(tvDetailEntities);
        assertEquals(tvDetail.getId(), tvDetailEntities.getId());
    }
}