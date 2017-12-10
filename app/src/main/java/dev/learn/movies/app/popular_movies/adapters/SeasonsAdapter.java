package dev.learn.movies.app.popular_movies.adapters;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dev.learn.movies.app.popular_movies.R;
import dev.learn.movies.app.popular_movies.common.tv_show.Season;
import dev.learn.movies.app.popular_movies.util.DisplayUtils;
import dev.learn.movies.app.popular_movies.util.HTTPHelper;

/**
 * Created by sudhar on 12/10/17.
 */

public class SeasonsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Season> mSeasonList;
    private final OnItemClickHandler mHandler;

    public SeasonsAdapter(OnItemClickHandler handler) {
        mSeasonList = new ArrayList<>();
        mHandler = handler;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_season, parent, false);

        int width = parent.getMeasuredWidth();
        SeasonsHolder viewHolder = new SeasonsHolder(parent, view);
        viewHolder.adjustPosterHeight(width);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SeasonsHolder) holder).bind(position);
    }

    @Override
    public int getItemCount() {
        return mSeasonList.size();
    }

    public void setSeasonList(List<Season> seasonList) {
        this.mSeasonList = seasonList;
        notifyDataSetChanged();
    }

    class SeasonsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ViewGroup mParent;
        private final ImageView mSeasonPicImageView;
        private final TextView mSeasonNumberTextView;

        public SeasonsHolder(ViewGroup parent, View itemView) {
            super(itemView);
            mSeasonPicImageView = itemView.findViewById(R.id.image_view_season_pic);
            mSeasonNumberTextView = itemView.findViewById(R.id.text_view_season_number);
            itemView.setOnClickListener(this);
            mParent = parent;
        }

        public void bind(int position) {
            Season season = mSeasonList.get(position);
            if (season != null) {
                if (season.getPosterPath() != null) {
                    Uri posterUri = HTTPHelper.buildImageResourceUri(season.getPosterPath(), HTTPHelper.IMAGE_SIZE_MEDIUM);
                    DisplayUtils.fitImageInto(mSeasonPicImageView, posterUri);
                }

                mSeasonNumberTextView.setText("Season " + (season.getSeasonNumber() + 1));
            }
        }

        @Override
        public void onClick(View view) {
            mHandler.onItemClicked(mParent, view, getAdapterPosition());
        }

        public void adjustPosterHeight(int width) {
            mSeasonPicImageView.setLayoutParams(new FrameLayout.LayoutParams((int) (width / 2.5), (width / 2)));
        }
    }
}