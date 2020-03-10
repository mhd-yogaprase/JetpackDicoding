package com.dicoding.picodiploma.jetpackdicoding.ui.tv;

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
import com.dicoding.picodiploma.jetpackdicoding.data.source.remote.model.Tv;
import com.dicoding.picodiploma.jetpackdicoding.ui.detail.tv.DetailTvActivity;

import java.util.ArrayList;
import java.util.List;

import static com.dicoding.picodiploma.jetpackdicoding.utils.Constant.IMG_URL;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TvViewHolder> {
    private List<Tv> listTv = new ArrayList<>();

    void setTvData(List<Tv> listTv){
        if (listTv == null) return;
        this.listTv.clear();
        this.listTv.addAll(listTv);
    }

    @NonNull
    @Override
    public TvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_catalogue, parent, false);
        return new TvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvViewHolder holder, int position) {
        Tv tv = listTv.get(position);
        holder.bind(tv);

        holder.cvCatalogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailTvActivity.class);
                intent.putExtra("detail_tv_id", tv.getId());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listTv.size();
    }

    class TvViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvDate;
        private ImageView imgPoster;
        private CardView cvCatalogue;

        TvViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_item_title);
            tvDate = itemView.findViewById(R.id.tv_item_date);
            imgPoster = itemView.findViewById(R.id.img_item_poster);
            cvCatalogue = itemView.findViewById(R.id.cv_catalogue);
        }

        void bind(final Tv tv){
            String thumbnail = IMG_URL + tv.getPosterPath();

            tvName.setText(tv.getName());
            tvDate.setText(tv.getFirstAirDate().split("-")[0]);
            Glide.with(itemView.getContext())
                    .load(thumbnail)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgPoster);
        }
    }
}
