package com.dicoding.picodiploma.jetpackdicoding.ui.detail.movie;

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
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.MovieDetail;
import com.dicoding.picodiploma.jetpackdicoding.viewmodel.ViewModelFactory;

import static com.dicoding.picodiploma.jetpackdicoding.utils.Constant.IMG_URL;

public class DetailMovieActivity extends AppCompatActivity {
    private TextView tvTitle;
    private TextView tvDate;
    private TextView tvCount;
    private TextView tvOverview;
    private TextView tvAverage;
    private TextView tvStatus;
    private ImageView imgPoster;
    private ImageView imgBackdrop;

    public static final String EXTRA_DETAIL_MOVIE = "detail_movie_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tvTitle = findViewById(R.id.tv_detail_title);
        tvDate = findViewById(R.id.tv_detail_date);
        tvStatus = findViewById(R.id.tv_detail_status);
        tvAverage = findViewById(R.id.tv_detail_average);
        tvCount = findViewById(R.id.tv_detail_count);
        tvOverview = findViewById(R.id.tv_detail_overview);
        imgPoster = findViewById(R.id.img_detail_poster);
        imgBackdrop = findViewById(R.id.img_detail_backdrop);

        ProgressBar progressBar = findViewById(R.id.progressbar_detail);

        ViewModelFactory factory = ViewModelFactory.getInstance();
        DetailMovieViewModel detailMovieViewModel = new ViewModelProvider(this, factory).get(DetailMovieViewModel.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int movieId = extras.getInt(EXTRA_DETAIL_MOVIE);
            detailMovieViewModel.setSelectedMovie(movieId);

            progressBar.setVisibility(View.VISIBLE);
            detailMovieViewModel.getDetailMovie().observe(this, this::populateMovie);
            progressBar.setVisibility(View.GONE);
        }
    }

    private void populateMovie(MovieDetail movieDetail) {
        String poster = IMG_URL + movieDetail.getPosterPath();
        String backdrop = IMG_URL + movieDetail.getBackdropPath();

        tvTitle.setText(movieDetail.getTitle());
        tvDate.setText(movieDetail.getReleaseDate());
        tvAverage.setText(String.valueOf(movieDetail.getVoteAverage()));
        tvCount.setText(String.valueOf(movieDetail.getVoteCount()));
        tvStatus.setText(movieDetail.getStatus());

        tvOverview.setText(movieDetail.getOverview());

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
