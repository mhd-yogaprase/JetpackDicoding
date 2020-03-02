package com.dicoding.picodiploma.jetpackdicoding.ui.tv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    private RecyclerView rvTv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvTv = view.findViewById(R.id.rv_tv);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TvViewModel tvViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TvViewModel.class);
        List<TvEntity> listTv = tvViewModel.getTv();

        TvAdapter tvAdapter = new TvAdapter();
        tvAdapter.setTvData(listTv);

        rvTv.setLayoutManager(new LinearLayoutManager(getContext()));
        rvTv.setHasFixedSize(true);
        rvTv.setAdapter(tvAdapter);
    }
}
