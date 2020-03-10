package com.dicoding.picodiploma.jetpackdicoding.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.RemoteDataSource;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Movie;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.MovieDetail;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Tv;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.TvDetail;

import java.util.List;

public class FakeCatalogueRepository implements CatalogueDataSource {

    private final RemoteDataSource remoteDataSource;

    FakeCatalogueRepository(@NonNull RemoteDataSource remoteDataSource){
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public LiveData<List<Movie>> getAllMovie() {
        final MutableLiveData<List<Movie>> movieList = new MutableLiveData<>();
        remoteDataSource.getAllMovie(movieList::postValue);
        return movieList;
    }

    @Override
    public LiveData<MovieDetail> getMovieDetail(final int movieId){
        MutableLiveData<MovieDetail> movieDetailData = new MutableLiveData<>();
        remoteDataSource.getMovieDetail(movieId, movieDetailData::postValue);
        return movieDetailData;
    }

    @Override
    public LiveData<List<Tv>> getAllTv(){
        MutableLiveData<List<Tv>> tvList = new MutableLiveData<>();
        remoteDataSource.getAllTv(tvList::postValue);
        return tvList;
    }

    @Override
    public LiveData<TvDetail> getTvDetail(final int tvId){
        MutableLiveData<TvDetail> tvDetailData = new MutableLiveData<>();
        remoteDataSource.getTvDetail(tvId, tvDetailData::postValue);
        return tvDetailData;
    }
}