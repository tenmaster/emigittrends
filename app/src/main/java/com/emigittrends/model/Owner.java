package com.emigittrends.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by emiliano on 23/02/18.
 */

public class Owner {

    @SerializedName("login")
    String login;
    @SerializedName("avatar_url")
    String avatarUrl;

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

}
