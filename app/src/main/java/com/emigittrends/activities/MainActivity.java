package com.emigittrends.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.emigittrends.R;
import com.emigittrends.model.GitRepository;
import com.emigittrends.model.HotRespositoriesResponse;
import com.emigittrends.network.EmiHttpClient;
import com.emigittrends.network.EmiHttpClient.HttpClientListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HttpClientListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmiHttpClient.getInstance().getHotRepositories(this);
    }

    @Override
    public void onRepositoriesRequestSuccess(ArrayList<GitRepository> repositories) {
        
    }

    @Override
    public void onRepositoriesRequestFailed() {
        Toast.makeText(this, getString(R.string.error_loading_repositories), Toast.LENGTH_SHORT).show();
    }
}
