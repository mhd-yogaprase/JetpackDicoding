package com.dicoding.picodiploma.jetpackdicoding.ui.detail.tv;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.jetpackdicoding.R;
import com.dicoding.picodiploma.jetpackdicoding.data.TvEntity;

public class DetailTvActivity extends AppCompatActivity {
    private TextView tvName;
    private TextView tvDate;
    private TextView tvGenre;
    private TextView tvOverview;
    private TextView tvRuntime;
    private ImageView imgPoster;

    public static final String EXTRA_DETAIL_TV = "tv_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() == null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tvName = findViewById(R.id.tv_title);
        tvDate = findViewById(R.id.tv_date);
        tvRuntime = findViewById(R.id.tv_time);
        tvGenre = findViewById(R.id.tv_genre);
        tvOverview = findViewById(R.id.tv_overview);
        imgPoster = findViewById(R.id.img_poster);

        DetailTvViewModel tvViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailTvViewModel.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String tvId = extras.getString(EXTRA_DETAIL_TV);
            if (tvId != null) {
                tvViewModel.setSelectedTv(tvId);
                TvEntity tvEntity = tvViewModel.getDetailsTv();
                populateTv(tvEntity);
            }
        }

    }

    private void populateTv(TvEntity tvEntity) {
        tvName.setText(tvEntity.getName());
        tvDate.setText(tvEntity.getFirstAirDate());
        tvRuntime.setText(tvEntity.getRuntime());
        tvGenre.setText(tvEntity.getGenre());
        tvOverview.setText(tvEntity.getOverview());

        Glide.with(this)
                .load(getResources().getIdentifier(tvEntity.getPoster(), "drawable", getApplicationContext().getPackageName()))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(imgPoster);
    }
}

