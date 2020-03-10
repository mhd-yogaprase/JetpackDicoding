package com.dicoding.picodiploma.jetpackdicoding.ui.tv;

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

public class TvFragment extends Fragment {
    private RecyclerView rvTv;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvTv = view.findViewById(R.id.rv_tv);
        progressBar = view.findViewById(R.id.progressbar_home);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance();
            TvViewModel tvViewModel = new ViewModelProvider(this, factory).get(TvViewModel.class);

            TvAdapter tvAdapter = new TvAdapter();
            progressBar.setVisibility(View.VISIBLE);
            tvViewModel.getTv().observe(this, tvs -> {
                progressBar.setVisibility(View.GONE);
                tvAdapter.setTvData(tvs);
                tvAdapter.notifyDataSetChanged();
            });

            rvTv.setLayoutManager(new LinearLayoutManager(getContext()));
            rvTv.setHasFixedSize(true);
            rvTv.setAdapter(tvAdapter);
        }
    }
}
