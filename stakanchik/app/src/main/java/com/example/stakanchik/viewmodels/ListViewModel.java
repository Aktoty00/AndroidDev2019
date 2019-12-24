package com.example.stakanchik.viewmodels;

import androidx.lifecycle.ViewModel;
import com.example.stakanchik.models.News;

public class ListViewModel extends ViewModel{
    public String title, decription, dateTime, content, imageURL;

    public ListViewModel(News news) {
        this.title = news.title;
        this.decription = news.decription;
        this.dateTime = news.dateTime;
        this.content = news.content;
        this.imageURL = news.imageURL;
    }
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
