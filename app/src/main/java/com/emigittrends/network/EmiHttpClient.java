package com.emigittrends.network;

import com.emigittrends.model.GitRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by emiliano on 23/02/18.
 */

public class EmiHttpClient {

    private static EmiHttpClient instance;
    private static EmiGitAPI gitHubService;

    public static EmiHttpClient getInstance(){
        if(instance == null) {
            instance = new EmiHttpClient();
            start();
        }
        return instance;
    }

    private static void start() {
        gitHubService = EmiGitAPI.retrofit.create(EmiGitAPI.class);
    }

    private static void getHotRepositories(){
        Call<List<GitRepository>> call = gitHubService.getRepositories();
        call.enqueue(new Callback<List<GitRepository>>() {
            @Override
            public void onResponse(Call<List<GitRepository>> call, Response<List<GitRepository>> response) {

            }

            @Override
            public void onFailure(Call<List<GitRepository>> call, Throwable t) {

            }
        });
    }

}
