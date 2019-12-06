package com.example.stakanchik.viewmodels;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.lifecycle.ViewModel;


public class ListViewModel extends ViewModel{
    public String title, decription, dateTime, content, imageURL;

    public ListViewModel(String title, String decription, String dateTime, String content, String imageURL) {
        this.title = title;
        this.decription = decription;
        this.dateTime = dateTime;
        this.content = content;
        this.imageURL = imageURL;
    }

    public ListViewModel() {
    }

    protected ListViewModel(Parcel in) {
        title = in.readString();
        decription = in.readString();
        dateTime = in.readString();
        content = in.readString();
        imageURL = in.readString();
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
