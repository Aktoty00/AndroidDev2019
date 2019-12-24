package com.example.stakanchik.models;

public class News {
    public String title, decription, dateTime, content, imageURL;

    public News(String title, String decription, String dateTime, String content, String imageURL) {
        this.title = title;
        this.decription = decription;
        this.dateTime = dateTime;
        this.content = content;
        this.imageURL = imageURL;
    }

    public News() { }
    public String getTitle() {
        return title;
    }
    public String getDecription() {
        return decription;
    }
    public String getDateTime() {
        return dateTime;
    }
    public String getContent() {
        return content;
    }
    public String getImageURL() {
        return imageURL;
    }
}
