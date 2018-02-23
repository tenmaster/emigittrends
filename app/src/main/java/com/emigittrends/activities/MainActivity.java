package com.emigittrends.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.emigittrends.R;
import com.emigittrends.adapters.MainRepositoriesAdapter;
import com.emigittrends.model.GitRepository;
import com.emigittrends.network.EmiHttpClient;
import com.emigittrends.network.EmiHttpClient.HttpClientListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HttpClientListener{

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupAdapter();

        EmiHttpClient.getInstance().getHotRepositories(this);
    }

    private void setupAdapter() {
        mRecyclerView = findViewById(R.id.main_activity_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void onRepositoriesRequestSuccess(ArrayList<GitRepository> repositories) {
        mRecyclerView.setAdapter(new MainRepositoriesAdapter(repositories));
    }

    @Override
    public void onRepositoriesRequestFailed() {
        Toast.makeText(this, getString(R.string.error_loading_repositories), Toast.LENGTH_SHORT).show();
    }
}
