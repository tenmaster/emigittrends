package com.emigittrends.network;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.emigittrends.model.GitRepository;
import com.emigittrends.model.HotRespositoriesResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
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

    public void getHotRepositories(final HttpClientListener listener){
        Call<HotRespositoriesResponse> call = gitHubService.getRepositories();
        call.enqueue(new Callback<HotRespositoriesResponse>() {
            @Override
            public void onResponse(Call<HotRespositoriesResponse> call, Response<HotRespositoriesResponse> response) {
                listener.onRepositoriesRequestSuccess(response.body().getItems());
                Log.d("request", "Success!");
            }

            @Override
            public void onFailure(Call<HotRespositoriesResponse> call, Throwable t) {
                listener.onRepositoriesRequestFailed();
                Log.d("request", "Failure!");

            }
        });
    }

    public interface HttpClientListener{
        void onRepositoriesRequestSuccess(ArrayList<GitRepository> repositories);
        void onRepositoriesRequestFailed();
    }

}
