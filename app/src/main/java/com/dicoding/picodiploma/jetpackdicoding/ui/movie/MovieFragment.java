package com.dicoding.picodiploma.jetpackdicoding.ui.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.dicoding.picodiploma.jetpackdicoding.R;
import com.dicoding.picodiploma.jetpackdicoding.data.MovieEntity;

import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment {
    private List<MovieEntity> listMovie = new ArrayList<>();
    private RecyclerView rvContent;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar = view.findViewById(R.id.progress_bar);
        rvContent = view.findViewById(R.id.rv_content);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MovieViewModel movieViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MovieViewModel.class);
        List<MovieEntity> listMovie = movieViewModel.getMovies();

        MovieAdapter movieAdapter = new MovieAdapter();
        movieAdapter.setMoviesData(listMovie);

        rvContent.setLayoutManager(new LinearLayoutManager(getContext()));
        rvContent.setHasFixedSize(true);
        rvContent.setAdapter(movieAdapter);
    }
}
