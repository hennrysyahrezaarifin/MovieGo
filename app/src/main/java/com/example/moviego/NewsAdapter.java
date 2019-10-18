package com.example.moviego;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviego.model.Articles;
import com.example.moviego.model.NewsResponse;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    Context context;
    ArrayList<Articles> newsdetails;

    public NewsAdapter (Context context, ArrayList<Articles> newsdetails ) {
        this.context = context;
        this.newsdetails = newsdetails;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_news, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Articles newsI = newsdetails.get(position);
        Glide.with(context).load(newsI.getUrltoimage()).into(holder.imageView);
        holder.newsTitle.setText(newsI.getTitle());
        holder.newsDescription.setText(newsI.getDescription());
    }

    @Override
    public int getItemCount() {
        return newsdetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView newsTitle, newsDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageThumbnail);
            newsDescription = itemView.findViewById(R.id.news_description);
            newsTitle = itemView.findViewById(R.id.news_title);
        }
    }
}
