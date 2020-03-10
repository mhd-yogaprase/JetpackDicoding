package com.dicoding.picodiploma.jetpackdicoding.utils;

import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.MovieDetail;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.TvDetail;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.response.MovieResponse;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.response.TvResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("discover/movie")
    Call<MovieResponse> getMovie(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("discover/tv")
    Call<TvResponse> getTv(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("movie/{type}")
    Call<MovieResponse> getMovieType(
            @Path("type") String movieType,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("movie/{id}")
    Call<MovieDetail> getMovieDetail(
            @Path("id") int movieId,
            @Query("api_key") String apiKey,
            @Query("language") String language
    );

    @GET("tv/{id}")
    Call<TvDetail> getDetailTv(
            @Path("id") int tvId,
            @Query("api_key") String apiKey,
            @Query("language") String language
    );
}
