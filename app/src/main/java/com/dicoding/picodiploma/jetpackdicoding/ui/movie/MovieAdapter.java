package com.dicoding.picodiploma.jetpackdicoding.ui.movie;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.jetpackdicoding.R;
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Movie;
import com.dicoding.picodiploma.jetpackdicoding.ui.detail.movie.DetailMovieActivity;

import java.util.ArrayList;
import java.util.List;

import static com.dicoding.picodiploma.jetpackdicoding.utils.Constant.IMG_URL;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> listMovies = new ArrayList<>();

    void setMoviesData(List<Movie> listMovies){
        if (listMovies == null) return;
        this.listMovies.clear();
        this.listMovies.addAll(listMovies);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_catalogue, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = listMovies.get(position);
        holder.bind(movie);

        holder.cvCatalogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailMovieActivity.class);
                intent.putExtra("detail_movie_id", movie.getId());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvDate;
        private ImageView imgPoster;
        private CardView cvCatalogue;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDate = itemView.findViewById(R.id.tv_item_date);
            imgPoster = itemView.findViewById(R.id.img_item_poster);
            cvCatalogue = itemView.findViewById(R.id.cv_catalogue);
        }

        void bind(final Movie movie){
            String thumbnail = IMG_URL + movie.getPosterPath();

            tvTitle.setText(movie.getTitle());
            tvDate.setText(movie.getReleaseDate().split("-")[0]);
            Glide.with(itemView.getContext())
                    .load(thumbnail)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgPoster);
        }
    }
}
