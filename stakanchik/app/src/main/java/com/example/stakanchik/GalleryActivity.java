package com.example.stakanchik;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity {
    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("images") && getIntent().hasExtra("imageNames") && getIntent().hasExtra("imageShortDescription")&& getIntent().hasExtra("imageDateTime")){
            int image = getIntent().getIntExtra("images", -1);
            final String imageName = getIntent().getStringExtra("imageNames");
            final String imageShortDescription = getIntent().getStringExtra("imageShortDescription");
            final String imageDateTime = getIntent().getStringExtra("imageDateTime");
            ImageButton share_button = findViewById(R.id.full_share_button);
            share_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, imageName + "\n" + imageShortDescription);
                    startActivity(Intent.createChooser(shareIntent, "Share using"));
                }
            });
            setImage(image, imageName, imageShortDescription, imageDateTime);
        }
    }
    private void setImage(int image, String imageName, String imageShortDescription, String imageDateTime){
        ImageView full_image = findViewById(R.id.full_album);
        final TextView full_imageName = findViewById(R.id.full_album_title);
        TextView full_imageDescription = findViewById(R.id.full_album_description);
        TextView full_imageDateTime = findViewById(R.id.full_album_datetime);

        full_image.setImageResource(image);
        full_imageName.setText(imageName);
        full_imageDescription.setText(imageShortDescription);
        full_imageDateTime.setText(imageDateTime);
    }
}