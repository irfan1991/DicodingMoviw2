package com.andaratech.moviedicoding2.TV;

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

public class ListTVAdapter extends RecyclerView.Adapter<ListTVAdapter.CategoryTVViewHolder> {
    private Context context;
    private ArrayList<TV> tvs;

    public ListTVAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<TV> getTvs() {
        return tvs;
    }

    public void setTvs(ArrayList<TV> tvs) {
        this.tvs = tvs;
    }

    @NonNull
    @Override
    public ListTVAdapter.CategoryTVViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_row_tv,viewGroup,false);
        return new ListTVAdapter.CategoryTVViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ListTVAdapter.CategoryTVViewHolder categoryTVViewHolder, int i) {
        categoryTVViewHolder.txName.setText(getTvs().get(i).getName());
        categoryTVViewHolder.txRealease.setText(getTvs().get(i).getRelease());

        Glide.with(context)
                .load(getTvs().get(i).getPhoto())
                .apply(RequestOptions.overrideOf(55,55))
                .into(categoryTVViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getTvs().size();
    }

    public class CategoryTVViewHolder extends RecyclerView.ViewHolder {
        TextView txName;
        TextView txRealease;
        ImageView imgPhoto;

        public CategoryTVViewHolder(@NonNull View itemView) {
            super(itemView);
            txName = itemView.findViewById(R.id.tv_item_name);
            txRealease = itemView.findViewById(R.id.tv_item_realease);
            imgPhoto = itemView.findViewById(R.id.tv_img_item_photo);
        }
    }
}
