package com.example.apipractise.image_fetching;

public class Item {

    private String imageUrls, collections;
    private int likes, comments, downloads;
    public Item(String imageUrls, String collections, int likes, int comments, int downloads) {
        this.imageUrls = imageUrls;
        this.collections = collections;
        this.likes = likes;
        this.comments = comments;
        this.downloads = downloads;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public String getCollections() {
        return collections;
    }

    public int getComments() {
        return comments;
    }

    public int getDownloads() {
        return downloads;
    }

    public int getLikes() {
        return likes;
    }
}
