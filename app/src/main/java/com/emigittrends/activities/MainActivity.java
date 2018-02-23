package com.emigittrends.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.emigittrends.R;
import com.emigittrends.adapters.MainRepositoriesAdapter;
import com.emigittrends.model.GitRepository;
import com.emigittrends.network.EmiHttpClient;
import com.emigittrends.network.EmiHttpClient.HttpClientListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements HttpClientListener{

    @BindView(R.id.main_activity_progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.main_activity_recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupAdapter();

        EmiHttpClient.getInstance().getHotRepositories(this);
    }

    private void setupAdapter() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void onRepositoriesRequestSuccess(ArrayList<GitRepository> repositories) {
        mRecyclerView.setAdapter(new MainRepositoriesAdapter(this, repositories));
        mRecyclerView.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onRepositoriesRequestFailed() {
        Toast.makeText(this, getString(R.string.error_loading_repositories), Toast.LENGTH_SHORT).show();
        mProgressBar.setVisibility(View.GONE);
    }
}
