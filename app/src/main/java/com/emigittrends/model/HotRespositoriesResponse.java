package com.emigittrends.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by emiliano on 23/02/18.
 */

public class HotRespositoriesResponse {

    @SerializedName("total_count")
    String totalCount;

    @SerializedName("incomplete_results")
    String incompleteResults;

    @SerializedName("items")
    ArrayList<GitRepository> items;

    public ArrayList<GitRepository> getItems() {
        return items;
    }
}
