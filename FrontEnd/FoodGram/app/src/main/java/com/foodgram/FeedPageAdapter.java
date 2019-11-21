package com.foodgram;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class FeedPageAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<Photo> photos;

    public FeedPageAdapter(Context mContext, List<Photo> photos) {
        this.mContext = mContext;
        this.photos = photos;
        
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_feed_page,parent, false);
        return new PhotoHolder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Photo photo = photos.get(i);

        ((PhotoHolder) viewHolder).bind(photo);




    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    private class PhotoHolder extends RecyclerView.ViewHolder{

        ImageButton otherUserImage;
        TextView otherUserName;
        ImageButton postImage;

        PhotoHolder(View itemView){
            super(itemView);

            otherUserImage = itemView.findViewById(R.id.feed_profile_pics);
            otherUserName = itemView.findViewById(R.id.feed_username);

        }

        void bind(Photo photo){
            otherUserName.setText(photo.getUser().getUsername());

            Glide.with(mContext)
                    .load(photo.getUser().getProfile_pic())
                    .into(otherUserImage);

            Glide.with(mContext)
                    .load(photo.getPic())
                    .into(postImage);


        }









    }


}
