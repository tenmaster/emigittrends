package com.emigittrends.network;

import com.emigittrends.model.GitRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by emiliano on 23/02/18.
 */

public interface EmiGitAPI {

    @GET("/search/repositories?q=pushed:>2018-02-01&sort=stars&order=desc\n")
    Call<List<GitRepository>> getRepositories();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
