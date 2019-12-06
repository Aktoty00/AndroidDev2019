package com.example.stakanchik.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stakanchik.GalleryActivity;
import com.example.stakanchik.databinding.ListItemsBinding;
import com.example.stakanchik.viewmodels.ListViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyAdaper> {
    List<ListViewModel> data;
    Context context;
    private LayoutInflater layoutInflater;

    public ListAdapter(List<ListViewModel> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdaper onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ListItemsBinding listItemsBinding = ListItemsBinding.inflate(layoutInflater, parent, false);
        return new MyAdaper(listItemsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdaper holder, int position) {
        final ListViewModel dataViewModel = data.get(position);
        holder.bind(dataViewModel);
        Picasso.with(context)
                .load(data.get(position).getImageURL())
                .into(holder.listItemsBinding.album);
        holder.listItemsBinding.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareBody = dataViewModel.getTitle();
                String shareSub = dataViewModel.getDecription();
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody + "\n\n" + shareSub);
                context.startActivity(Intent.createChooser(shareIntent, "Share using"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyAdaper extends RecyclerView.ViewHolder {
        private ListItemsBinding listItemsBinding;


        public MyAdaper(ListItemsBinding listItemsBinding) {
            super(listItemsBinding.getRoot());
            this.listItemsBinding=listItemsBinding;

            listItemsBinding.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        Intent intent = new Intent(context, GalleryActivity.class);
                        intent.putExtra("image", data.get(pos).getImageURL());
                        intent.putExtra("imageName", data.get(pos).getTitle());
                        intent.putExtra("imageDescription", data.get(pos).getDecription());
                        intent.putExtra("content", data.get(pos).getContent());
                        intent.putExtra("imageDateTime", data.get(pos).getDateTime());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }
            });
        }
        public void bind(ListViewModel listViewModel){
            this.listItemsBinding.setViewModel(listViewModel);
        }

        public ListItemsBinding getListItemsBinding(){
            return listItemsBinding;
        }
    }
}
