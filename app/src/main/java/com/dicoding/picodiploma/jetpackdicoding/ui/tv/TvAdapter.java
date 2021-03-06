package com.dicoding.picodiploma.jetpackdicoding.ui.tv;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.jetpackdicoding.R;
import com.dicoding.picodiploma.jetpackdicoding.data.TvEntity;
import com.dicoding.picodiploma.jetpackdicoding.ui.detail.tv.DetailTvActivity;

import java.util.ArrayList;
import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TvViewHolder> {
    private List<TvEntity> listTv = new ArrayList<>();

    void setTvData(List<TvEntity> listTv){
        if (listTv == null) return;
        this.listTv.clear();
        this.listTv.addAll(listTv);
    }

    @NonNull
    @Override
    public TvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent, false);
        return new TvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvViewHolder holder, int position) {
        TvEntity tv = listTv.get(position);
        holder.bind(tv);

    }

    @Override
    public int getItemCount() {
        return listTv.size();
    }

    class TvViewHolder extends RecyclerView.ViewHolder {
        final TextView tvName;
        final TextView tvDate;
        final TextView tvOverview;
        final ImageView imgPoster;

        TvViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_title);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvOverview = itemView.findViewById(R.id.tv_overview);
            imgPoster = itemView.findViewById(R.id.img_poster);
        }

        void bind(final TvEntity tv){
            tvName.setText(tv.getName());
            tvDate.setText(tv.getFirstAirDate());
            tvOverview.setText(tv.getOverview());
            Glide.with(itemView.getContext())
                    .load(itemView.getResources().getIdentifier(tv.getPoster(),"drawable", itemView.getContext().getPackageName()))
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgPoster);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), DetailTvActivity.class);
                    intent.putExtra(DetailTvActivity.EXTRA_DETAIL_TV, tv.getId());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
