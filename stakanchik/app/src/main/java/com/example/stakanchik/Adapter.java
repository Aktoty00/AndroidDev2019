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
import com.squareup.picasso.Picasso;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    static List<ListItem> listItems;
    static Context myContext;

    public Adapter(List<ListItem> listItems, Context myContext) {
        this.listItems = listItems;
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_layout, parent, false);
        ViewHolder ViewHolder = new ViewHolder(view);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final ListItem listItem = listItems.get(position);
        holder.AlbumTitle.setText(listItem.getTitle());
        holder.AlbumDescription.setText(listItem.getDescriptioin());
        holder.AlbumDateTime.setText(listItem.getDateTime());
        Picasso.with(myContext)
            .load(listItem.getImageURL())
            .into(holder.Album);

        holder.AlbumShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareBody = listItem.getTitle();
                String shareSub = listItem.getDescriptioin();
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody + "\n\n" + shareSub);
                myContext.startActivity(Intent.createChooser(shareIntent, "Share using"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView Album;
        TextView AlbumTitle, AlbumDescription, AlbumDateTime;
        ImageButton AlbumShareButton;
        LinearLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Album = itemView.findViewById(R.id.album);
            AlbumTitle = itemView.findViewById(R.id.album_title);
            AlbumDescription = itemView.findViewById(R.id.album_description);
            AlbumDateTime = itemView.findViewById(R.id.album_datetime);
            AlbumShareButton = itemView.findViewById(R.id.share_button);
            parentLayout = itemView.findViewById(R.id.parent_layout);

            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        Intent intent = new Intent(myContext, GalleryActivity.class);
                        intent.putExtra("image", listItems.get(pos).getImageURL());
                        intent.putExtra("imageName", listItems.get(pos).getTitle());
                        intent.putExtra("imageDescription", listItems.get(pos).getDescriptioin());
                        intent.putExtra("content", listItems.get(pos).getContent());
                        intent.putExtra("imageDateTime", listItems.get(pos).getDateTime());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        myContext.startActivity(intent);
                    }
                }
            });
        }
    }
}


/*
    SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
    Date dt = sd1.parse(myString);

        SimpleDateFormat sd2 = new SimpleDateFormat("yyyy-MM-dd");
        String newDate = sd2.format(dt);
        System.out.println(newDate);
 */