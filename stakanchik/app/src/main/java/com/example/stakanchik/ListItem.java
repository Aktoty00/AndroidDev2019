package com.example.stakanchik;

public class ListItem {
    private String title;
    private String descriptioin;
    private String content;
    private String dateTime;
    private String imageURL;

    public ListItem(String title, String descriptioin, String dateTime, String imageURL, String content) {
        this.title = title;
        this.descriptioin = descriptioin;
        this.dateTime = dateTime;
        this.content = content;
        this.imageURL = imageURL;
    }

    public String getContent() {
        return content;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getTitle() {
        return title;
    }

    public String getDescriptioin() {
        return descriptioin;
    }

    public String getDateTime() {
        return dateTime;
    }
}
