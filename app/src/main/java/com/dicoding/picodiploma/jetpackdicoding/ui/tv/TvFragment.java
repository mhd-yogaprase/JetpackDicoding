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
import com.dicoding.picodiploma.jetpackdicoding.data.TvEntity;

import java.util.List;

public class TvFragment extends Fragment {
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

        rvContent = view.findViewById(R.id.rv_content);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TvViewModel tvViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TvViewModel.class);
        List<TvEntity> listTv = tvViewModel.getTv();

        TvAdapter tvAdapter = new TvAdapter();
        tvAdapter.setTvData(listTv);

        rvContent.setLayoutManager(new LinearLayoutManager(getContext()));
        rvContent.setHasFixedSize(true);
        rvContent.setAdapter(tvAdapter);
    }
}
