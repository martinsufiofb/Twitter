package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class TweetDetails extends AppCompatActivity {

    Tweet tweet;

    // the view objects
    TextView tvScreenName;
    TextView tvTweet;
    ImageView ivprofile;
    ImageView ivimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_details);

        tvScreenName = findViewById(R.id.tvScreenName);
        tvTweet = findViewById(R.id.tvBody);
        ivprofile = findViewById(R.id.ivProfileImage);
        ivimage = findViewById(R.id.ivimage);

        tweet = (Tweet) Parcels.unwrap(getIntent().getParcelableExtra(Tweet.class.getSimpleName()));

        tvScreenName.setText(tweet.user.screenName);
        tvTweet.setText(tweet.body);
        Glide.with(this).load(tweet.user.profileImageUrl).transform(new RoundedCorners(60)).into(ivprofile);
        Glide.with(this).load(tweet.imageUrl).into(ivimage);
    }
}