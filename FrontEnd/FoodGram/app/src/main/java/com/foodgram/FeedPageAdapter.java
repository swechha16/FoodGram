package com.foodgram;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

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
        TextView photoCaption;
        ImageView postImage;

        PhotoHolder(View itemView){
            super(itemView);

            otherUserImage = itemView.findViewById(R.id.feed_profile_pics);
            otherUserName = itemView.findViewById(R.id.feed_username);
            postImage = itemView.findViewById(R.id.image_post);
            photoCaption = itemView.findViewById(R.id.feedphotoCaption);

        }

        void bind(final Photo photo){

            final String otherUsername = photo.getUser().getUsername();
            otherUserName.setText(otherUsername);
            photoCaption.setText((photo.getCaption()));

            otherUserImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Parcelable parcelable = Parcels.wrap(photo.getUser());
                    Intent intent = new Intent(mContext, Other_Users_Profile.class);
                    intent.putExtra("OtherUserProfile", parcelable);
                        view.getContext().startActivity(intent);

                }
            });

            Glide.with(mContext)
                    .load(photo.getPic())
                    .into(postImage);
            Glide.with(mContext)
                    .load(photo.getUser().getProfile_pic())
                    .into(otherUserImage);

        }









    }

    public void add(Photo p){
        photos.add(p);
        notifyDataSetChanged();
    }


}
