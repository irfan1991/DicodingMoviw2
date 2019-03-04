package com.andaratech.moviedicoding2.Movie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andaratech.moviedicoding2.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public  class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Movie> movies;

    public ListMovieAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public ListMovieAdapter.CategoryViewHolder onCreateViewHolder
            (@NonNull ViewGroup viewGroup, int i) {
      View itemRow = LayoutInflater.from(viewGroup.getContext()).
              inflate(R.layout.item_row_movie,viewGroup,false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder
            (@NonNull ListMovieAdapter.CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.txName.setText(getMovies().get(i).getName());
        categoryViewHolder.txRealease.setText(getMovies().get(i).getRelease());

        Glide.with(context)
                .load(getMovies().get(i).getPhoto())
                .apply(RequestOptions.overrideOf(55,55))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getMovies().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView txName;
        TextView txRealease;
        ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txName = itemView.findViewById(R.id.movie_item_name);
            txRealease = itemView.findViewById(R.id.movie_item_realease);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
