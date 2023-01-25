package com.skyblue.mvvmretrofitactivity.models;

public class UserModel {
    String name;
    String image;
    String post_image;

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPost_image(String post_image) {
        this.post_image = post_image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getPost_image() {
        return post_image;
    }
}
