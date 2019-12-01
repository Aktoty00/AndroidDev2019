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
import com.squareup.picasso.Picasso;

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
        if(getIntent().hasExtra("image") && getIntent().hasExtra("imageName") && getIntent().hasExtra("content") && getIntent().hasExtra("imageDescription")&& getIntent().hasExtra("imageDateTime")){

            ImageView full_image = findViewById(R.id.full_album);
            Intent intent= getIntent();
            String image = String.valueOf(intent.getStringExtra("image"));
            Picasso.with(this)
                    .load(image)
                    .into(full_image);

            final String imageName = getIntent().getStringExtra("imageName");
            final String mycontent = getIntent().getStringExtra("content");
            final String imageDateTime = getIntent().getStringExtra("imageDateTime");
            ImageButton share_button = findViewById(R.id.full_share_button);
            share_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, imageName + "\n\n" + mycontent);
                    startActivity(Intent.createChooser(shareIntent, "Share using"));
                }
            });
            setImage(imageName, mycontent, imageDateTime);
        }
    }
    private void setImage(String imageName, String mycontent, String imageDateTime){
        final TextView full_imageName = findViewById(R.id.full_album_title);
        TextView full_imageDescription = findViewById(R.id.full_album_description);
        TextView full_imageDateTime = findViewById(R.id.full_album_datetime);

        full_imageName.setText(imageName);
        full_imageDescription.setText(mycontent);
        full_imageDateTime.setText(imageDateTime);
    }
}