package com.dicoding.picodiploma.jetpackdicoding.data.source.remote;

import android.util.Log;

import androidx.annotation.NonNull;

import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Movie;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.MovieDetail;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Tv;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.TvDetail;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.response.MovieResponse;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.response.TvResponse;
import com.dicoding.picodiploma.jetpackdicoding.utils.ApiService;
import com.dicoding.picodiploma.jetpackdicoding.utils.EspressoIdlingResource;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.dicoding.picodiploma.jetpackdicoding.utils.Constant.API_KEY;
import static com.dicoding.picodiploma.jetpackdicoding.utils.Constant.LANGUAGE;
import static com.dicoding.picodiploma.jetpackdicoding.utils.Constant.PAGE;

public class RemoteDataSource {
    private final String TAG = RemoteDataSource.class.getSimpleName();

    private static RemoteDataSource INSTANCE;
    private ApiService apiService;

    private RemoteDataSource(ApiService apiService) {
        this.apiService = apiService;
    }

    public static RemoteDataSource getInstance(ApiService apiService){
        if (INSTANCE == null){
            INSTANCE = new RemoteDataSource(apiService);
        }
        return INSTANCE;
    }

    public void getAllMovie(LoadMovieCallback callback){
        EspressoIdlingResource.increment();
        apiService.getMovie(API_KEY, LANGUAGE, PAGE).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onAllMovieReceived(response.body().getMovieResults());
                        EspressoIdlingResource.decrement();
                    }
                }
            }


            @Override
            public void onFailure(@NonNull Call<MovieResponse> call, @NonNull Throwable t) {
                Log.e(TAG, "Failed getting movie" + t.getMessage());
            }
        });
    }

    public void getMovieDetail(int movieId, LoadMovieDetailCallback callback){
        EspressoIdlingResource.increment();
        apiService.getMovieDetail(movieId, API_KEY, LANGUAGE).enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(@NonNull Call<MovieDetail> call, @NonNull Response<MovieDetail> response) {
                if (response.isSuccessful()){
                    callback.onMovieDetailReceived(response.body());
                    EspressoIdlingResource.decrement();
                }

            }

            @Override
            public void onFailure(@NonNull Call<MovieDetail> call, @NonNull Throwable t) {

            }
        });
    }

    public void getAllTv(LoadTvCallback callback){
        EspressoIdlingResource.increment();
        apiService.getTv(API_KEY, LANGUAGE, PAGE).enqueue(new Callback<TvResponse>() {
            @Override
            public void onResponse(@NonNull Call<TvResponse> call, @NonNull Response<TvResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() != null) {
                        callback.onAllTvReceived(response.body().getTvResults());
                        EspressoIdlingResource.decrement();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<TvResponse> call, @NonNull Throwable t) {

            }
        });
    }

    public void getTvDetail(int tvId, LoadTvDetailCallback callback){
        EspressoIdlingResource.increment();
        apiService.getDetailTv(tvId, API_KEY, LANGUAGE).enqueue(new Callback<TvDetail>() {
            @Override
            public void onResponse(@NonNull Call<TvDetail> call, @NonNull Response<TvDetail> response) {
                if (response.isSuccessful()){
                    callback.onTvDetailReceived(response.body());
                    EspressoIdlingResource.decrement();
                }
            }

            @Override
            public void onFailure(@NonNull Call<TvDetail> call, @NonNull Throwable t) {

            }
        });
    }


    public interface LoadMovieCallback {
        void onAllMovieReceived(ArrayList<Movie> movie);
    }

    public interface LoadMovieDetailCallback{
        void onMovieDetailReceived(MovieDetail movieDetail);
    }

    public interface LoadTvCallback{
        void onAllTvReceived(ArrayList<Tv> tv);
    }

    public interface LoadTvDetailCallback{
        void onTvDetailReceived(TvDetail tvDetail);
    }
}
