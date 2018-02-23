package com.emigittrends.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emigittrends.model.GitRepository;

import java.util.ArrayList;
import com.emigittrends.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by emiliano on 23/02/18.
 */

public class MainRepositoriesAdapter extends RecyclerView.Adapter<MainRepositoriesAdapter.ViewHolder> {

    private ArrayList<GitRepository> mRepositoriesDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_repository_title) TextView mRepositoryNameTextview;
        @BindView(R.id.item_repository_stars) TextView mRepositoryStarsTextview;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public MainRepositoriesAdapter(ArrayList<GitRepository> mRepositoriesDataset) {
        this.mRepositoriesDataset = mRepositoriesDataset;
    }

    @Override
    public MainRepositoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_repository, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         holder.mRepositoryNameTextview.setText(mRepositoriesDataset.get(position).getName());
         holder.mRepositoryStarsTextview.setText(mRepositoriesDataset.get(position).getStarsCount());

    }

    @Override
    public int getItemCount() {
        return mRepositoriesDataset.size();
    }
}
