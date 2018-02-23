package com.emigittrends.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by emiliano on 23/02/18.
 */

public class Owner implements Serializable {

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
