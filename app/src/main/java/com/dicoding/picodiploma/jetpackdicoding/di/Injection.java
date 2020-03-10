package com.dicoding.picodiploma.jetpackdicoding.di;

import com.dicoding.picodiploma.jetpackdicoding.data.source.CatalogueRepository;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.RemoteDataSource;
import com.dicoding.picodiploma.jetpackdicoding.utils.ApiClient;
import com.dicoding.picodiploma.jetpackdicoding.utils.ApiService;

public class Injection {
    public static CatalogueRepository provideRepository(){
        RemoteDataSource remoteRepository = RemoteDataSource.getInstance(ApiClient.getClient().create(ApiService.class));
        return CatalogueRepository.getInstance(remoteRepository);
    }
}
