package com.example.apipractise.MovieFetching;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apipractise.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder>{

    private Context context;
    private List<Movie> movieList;

    public MovieAdapter(Context context , List<Movie> movies){
        this.context = context;
        movieList = movies;
    }
    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item , parent , false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.title.setText(movie.getTitle());
        holder.rating.setText(String.valueOf(movie.getRating()));
        holder.overview.setText(movie.getOverview());
        Glide.with(context).load(movie.getPoster()).into(holder.imageView);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title" , movie.getTitle());
                bundle.putString("poster" , movie.getPoster());
                bundle.putString("overview" , movie.getOverview());
                bundle.putDouble("rating" , movie.getRating());

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title , rating , overview;
        ConstraintLayout constraintLayout;
        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageviewMovie);
            title = itemView.findViewById(R.id.title);
            rating = itemView.findViewById(R.id.rating);
            overview = itemView.findViewById(R.id.overview);
            constraintLayout = itemView.findViewById(R.id.item_layout);

        }
    }
}
