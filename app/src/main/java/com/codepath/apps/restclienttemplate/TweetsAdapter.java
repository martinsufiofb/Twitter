package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetsAdapter extends  RecyclerView.Adapter<TweetsAdapter.ViewHolder>{
     Context context;
     List<Tweet> tweets;


    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

        // Clean all elements of the recycler
        public void clear() {
            tweets.clear();
            notifyDataSetChanged();
        }

        // Add a list of items -- change to type used
        public void addAll(List<Tweet> list) {
            tweets.addAll(list);
            notifyDataSetChanged();
        }

    // for each row, inflate the layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }

    //bind values based on the position
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get the data
        Tweet tweet = tweets.get(position);

        holder.bind(tweet);
    }


    @Override
    public int getItemCount() {
        return tweets.size();
    }

    // Define a viewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{


        ImageView ivProfileImage;
        TextView tvBody;
        TextView tvScreenName;
        ImageView ivimage;
        TextView tvlastseen;
        ImageView ivcomment;
//        TextView textView2;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
            ivimage = itemView.findViewById(R.id.ivimage);
            tvlastseen = itemView.findViewById(R.id.tvlastseen);
            ivcomment = itemView.findViewById(R.id.ivreply);
//            textView2 = itemView.findViewById(R.id.textView2);

        }

        public void bind(Tweet tweet) {
            tvBody.setText(tweet.body);
            tvScreenName.setText(tweet.user.screenName);
            tvlastseen.setText(tweet.lastseen);
//            textView2.setText(tweet.user.username);
            Glide.with(context).load(tweet.user.profileImageUrl).transform(new RoundedCorners(60)).into(ivProfileImage);
            Glide.with(context).load(tweet.imageUrl).into(ivimage);

            ivcomment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,CommentActivity.class);
                    context.startActivity(intent);
                }
            });

        }


    }


}
