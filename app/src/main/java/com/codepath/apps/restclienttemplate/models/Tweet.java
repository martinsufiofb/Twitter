package com.codepath.apps.restclienttemplate.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Tweet {
    public String body;
    public String createdAt;
    public User user;
    public String imageUrl;

    public Tweet(){}


    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        tweet.imageUrl = "";

        if (jsonObject.has("full_text")){
            tweet.body = jsonObject.getString("full_text");
        }else{
            tweet.body = jsonObject.getString("text");
        }
        if (jsonObject.getJSONObject("entities").has("media")){
            JSONArray media = jsonObject.getJSONObject("entities").getJSONArray("media");
            if (media.length()>0){
                tweet.imageUrl = media.getJSONObject(0).getString("media_url_https").toString();
            }
        }

        return tweet;
    }

    public static  List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i<jsonArray.length(); i++){
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }

}
