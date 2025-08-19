package com.example.apipractise.image_fetching;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apipractise.R;

import java.util.List;

public class postAdapter extends RecyclerView.Adapter<postAdapter.postHolder> {

    Context context;
    List<Item> postList;
    public postAdapter(Context context, List<Item> postList) {
        this.context = context;
        this.postList = postList;
    }


    @NonNull
    @Override
    public postHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.each_item,parent,false);
        return new postHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull postHolder holder, int position) {
          Item item = postList.get(position);
          holder.setImageView(item.getImageUrls());
          holder.setCollections(item.getCollections());
          holder.setLikes(item.getLikes());
          holder.setComments(item.getComments());
          holder.setDownloads(item.getDownloads());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class postHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView collections,likes, comments, downloads;
        View view;
        public postHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
        public void setImageView(String url){
            imageView = view.findViewById(R.id.imageView);
            Glide.with(context).load(url).into(imageView);

        }
        public void setCollections(String collection){
            collections = view.findViewById(R.id.collection);
            collections.setText(collection + "\n"+ "Collection");
        }
        public void setLikes(int mLikes){
            likes = view.findViewById(R.id.likes);
            likes.setText(mLikes + "\n" +" Likes");
        }
        public void setComments(int mComments){
            comments = view.findViewById(R.id.Comments);
            comments.setText(mComments + "\n" + " Comments");
        }
        public void setDownloads(int mDownloads){
            downloads = view.findViewById(R.id.Downloads);
            downloads.setText(mDownloads + "\n" + " Downloads");
        }
    }
}
