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
import com.dicoding.picodiploma.jetpackdicoding.viewmodel.ViewModelFactory;

public class MovieFragment extends Fragment {
    private RecyclerView rvMovie;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvMovie = view.findViewById(R.id.rv_movie);
        progressBar = view.findViewById(R.id.progressbar_home);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance();
            MovieViewModel movieViewModel = new ViewModelProvider(this, factory).get(MovieViewModel.class);

            MovieAdapter movieAdapter = new MovieAdapter();
            progressBar.setVisibility(View.VISIBLE);
            movieViewModel.getMovies().observe(this, movies -> {
                        progressBar.setVisibility(View.GONE);
                        movieAdapter.setMoviesData(movies);
                        movieAdapter.notifyDataSetChanged();
                    }
            );

            rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovie.setHasFixedSize(true);
            rvMovie.setAdapter(movieAdapter);
        }
    }
}
