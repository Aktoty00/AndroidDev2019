package com.example.stakanchik;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Adapter extends RecyclerView.Adapter<Adapter.ImageViewHolder> {
    ArrayList<Integer> images;
    ArrayList<String> imageNames;
    ArrayList<String> imagesShortDescription;
    ImageButton shareButton;
    Context myContext;

    public Adapter(ArrayList<Integer> images, ArrayList<String> imageNames, ArrayList<String> imagesShortDescription, ImageButton shareButton, Context myContext) {
        this.images = images;
        this.imageNames = imageNames;
        this.imagesShortDescription = imagesShortDescription;
        this.shareButton = shareButton;
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_layout, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {
        holder.Album.setImageResource(images.get(position));
        holder.AlbumTitle.setText(imageNames.get(position));
        holder.AlbumDescription.setText(imagesShortDescription.get(position));

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat timeStampFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        final String currentDateTime = timeStampFormat.format(calendar.getTime());

        holder.AlbumDateTime.setText(currentDateTime);
        holder.AlbumShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareBody = imageNames.get(position);
                String shareSub = imagesShortDescription.get(position);
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody + "\n" + shareSub);
                myContext.startActivity(Intent.createChooser(shareIntent, "Share using"));
            }
        });
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myContext, GalleryActivity.class);
                intent.putExtra("images", images.get(position));
                intent.putExtra("imageNames", imageNames.get(position));
                intent.putExtra("imageShortDescription", imagesShortDescription.get(position));
                intent.putExtra("imageDateTime", currentDateTime);
                myContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageNames.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder
    {
        ImageView Album;
        TextView AlbumTitle;
        TextView AlbumDescription;
        TextView AlbumDateTime;
        ImageButton AlbumShareButton;
        LinearLayout parentLayout;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            Album = itemView.findViewById(R.id.album);
            AlbumTitle = itemView.findViewById(R.id.album_title);
            AlbumDescription = itemView.findViewById(R.id.album_description);
            AlbumDateTime = itemView.findViewById(R.id.album_datetime);
            AlbumShareButton = itemView.findViewById(R.id.share_button);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
