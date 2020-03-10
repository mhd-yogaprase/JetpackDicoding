package com.dicoding.picodiploma.jetpackdicoding.ui.detail.tv;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.jetpackdicoding.R;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.TvDetail;
import com.dicoding.picodiploma.jetpackdicoding.viewmodel.ViewModelFactory;

import static com.dicoding.picodiploma.jetpackdicoding.utils.Constant.IMG_URL;

public class DetailTvActivity extends AppCompatActivity {
    private TextView tvName;
    private TextView tvDate;
    private TextView tvStatus;
    private TextView tvOverview;
    private TextView tvAverage;
    private TextView tvCount;
    private ImageView imgPoster;
    private ImageView imgBackdrop;

    public static final String EXTRA_DETAIL_TV = "detail_tv_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tvName = findViewById(R.id.tv_detail_title);
        tvDate = findViewById(R.id.tv_detail_date);
        tvAverage = findViewById(R.id.tv_detail_average);
        tvCount = findViewById(R.id.tv_detail_count);
        tvOverview = findViewById(R.id.tv_detail_overview);
        tvStatus = findViewById(R.id.tv_detail_status);
        imgPoster = findViewById(R.id.img_detail_poster);
        imgBackdrop = findViewById(R.id.img_detail_backdrop);

        ProgressBar progressBar = findViewById(R.id.progressbar_detail);

        ViewModelFactory factory = ViewModelFactory.getInstance();
        DetailTvViewModel tvViewModel = new ViewModelProvider(this, factory).get(DetailTvViewModel.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int tvId = extras.getInt(EXTRA_DETAIL_TV);
                tvViewModel.setSelectedTv(tvId);

                progressBar.setVisibility(View.VISIBLE);
                tvViewModel.getTvDetail().observe(this, this::populateTv);
                progressBar.setVisibility(View.GONE);
        }
    }

    private void populateTv(TvDetail tvDetail) {
        String poster = IMG_URL + tvDetail.getPosterPath();
        String backdrop = IMG_URL + tvDetail.getBackdropPath();

        tvName.setText(tvDetail.getName());
        tvDate.setText(tvDetail.getFirstAirDate());
        tvStatus.setText(tvDetail.getStatus());
        tvAverage.setText(String.valueOf(tvDetail.getVoteAverage()));
        tvCount.setText(String.valueOf(tvDetail.getVoteCount()));
        tvOverview.setText(tvDetail.getOverview());

        Glide.with(this)
                .load(poster)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(imgPoster);

        Glide.with(this)
                .load(backdrop)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(imgBackdrop);
    }
}

