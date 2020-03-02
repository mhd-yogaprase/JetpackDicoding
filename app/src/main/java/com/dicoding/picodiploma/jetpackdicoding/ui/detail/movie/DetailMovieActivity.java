package com.dicoding.picodiploma.jetpackdicoding.ui.detail.movie;

import android.os.Bundle;
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
import com.dicoding.picodiploma.jetpackdicoding.data.MovieEntity;

public class DetailMovieActivity extends AppCompatActivity {
    private TextView tvTitle;
    private TextView tvDate;
    private TextView tvGenre;
    private TextView tvOverview;
    private TextView tvRuntime;
    private ImageView imgPoster;

    public static final String EXTRA_DETAIL_MOVIE = "content_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar()==null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tvTitle = findViewById(R.id.tv_title);
        tvDate = findViewById(R.id.tv_date);
        tvRuntime = findViewById(R.id.tv_time);
        tvGenre = findViewById(R.id.tv_genre);
        tvOverview = findViewById(R.id.tv_overview);
        imgPoster = findViewById(R.id.img_poster);

        DetailMovieViewModel detailMovieViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailMovieViewModel.class);
        Bundle extras = getIntent().getExtras();
        if (extras !=null){
            String movieId = extras.getString(EXTRA_DETAIL_MOVIE);
            if (movieId !=null){
                detailMovieViewModel.setSelectedMovie(movieId);
                MovieEntity movieEntity = detailMovieViewModel.getDetailsMovie();
                populateContent(movieEntity);
            }
        }
    }

    private void populateContent(MovieEntity movieEntity){
        tvTitle.setText(movieEntity.getTitle());
        tvDate.setText(movieEntity.getReleaseDate());
        tvRuntime.setText(movieEntity.getRuntime());
        tvGenre.setText(movieEntity.getGenre());
        tvOverview.setText(movieEntity.getOverview());

        Glide.with(this)
                .load(getResources().getIdentifier(movieEntity.getPoster(), "drawable", getApplicationContext().getPackageName()))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(imgPoster);
    }
}
