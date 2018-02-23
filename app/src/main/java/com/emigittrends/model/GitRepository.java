package com.emigittrends.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by emiliano on 23/02/18.
 */

public class GitRepository {

    @SerializedName("id")
    String id;
    @SerializedName("full_name")
    String fullName;
    @SerializedName("description")
    String description;
    @SerializedName("watchers_count")
    String watchersCount;
    @SerializedName("stargazers_count")
    String starsCount;
    @SerializedName("forks")
    String forks;
    @SerializedName("language")
    String language;
    @SerializedName("url")
    String url;
    @SerializedName("owner")
    Owner owner;

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public String getWatchersCount() {
        return watchersCount;
    }

    public String getStarsCount() {
        return starsCount;
    }

    public String getForks() {
        return forks;
    }

    public String getLanguage() {
        return language;
    }

    public String getUrl() {
        return url;
    }

    public Owner getOwner() {
        return owner;
    }
}
