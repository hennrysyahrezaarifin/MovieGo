package com.example.moviego;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviego.model.MovieResponse;
import com.example.moviego.model.Results;

import org.w3c.dom.Comment;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
Context context;
ArrayList<Results> movie;

public MovieAdapter(Context context, ArrayList<Results> movie) {
    this.context = context;
    this.movie = movie;
}

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_comment,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
    final Results movieI = movie.get(position);
        Glide.with(context).load("https://image.tmdb.org/t/p/w200"+movieI.
                getPosterPath()).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return movie.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView poster;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.imagePoster);
        }
    }
}
