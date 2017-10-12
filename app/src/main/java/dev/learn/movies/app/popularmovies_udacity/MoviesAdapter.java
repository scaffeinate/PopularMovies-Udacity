package dev.learn.movies.app.popularmovies_udacity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dev.learn.movies.app.popularmovies_udacity.common.Movie;
import dev.learn.movies.app.popularmovies_udacity.network.HTTPHelper;

/**
 * Created by sudharti on 10/10/17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private List<Movie> movieList;
    private Context mContext;
    private OnItemClickHandler mHandler;

    public MoviesAdapter(Context context, OnItemClickHandler handler) {
        this.mContext = context;
        this.mHandler = handler;
        this.movieList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, null);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView mPosterImageView;
        private final RelativeLayout mPlaceholder;

        public ViewHolder(View itemView) {
            super(itemView);
            mPosterImageView = itemView.findViewById(R.id.imageview_poster);
            mPlaceholder = itemView.findViewById(R.id.layout_placeholder);
            mPosterImageView.setOnClickListener(this);
        }

        private void bind(int position) {
            Movie movie = movieList.get(position);
            //TODO (1) Fallback if the image is not present
            Picasso.with(mContext)
                    .load(HTTPHelper.buildImageResourceUri(movie.getPosterPath()))
                    .into(mPosterImageView, new Callback() {
                        @Override
                        public void onSuccess() {
                            mPosterImageView.setVisibility(View.VISIBLE);
                            mPlaceholder.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onError() {
                        }
                    });
        }

        @Override
        public void onClick(View view) {
            mHandler.onClick(getAdapterPosition());
        }
    }

    interface OnItemClickHandler {
        void onClick(int position);
    }
}
