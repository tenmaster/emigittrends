package com.emigittrends.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.emigittrends.R;
import com.emigittrends.model.GitRepository;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.detail_owner_textview)
    TextView mOwnerTextView;
    @BindView(R.id.detail_ownertype_textview)
    TextView mOwnerTypeTextView;
    @BindView(R.id.detail_picture_imageview)
    ImageView mPictureImageView;
    @BindView(R.id.detail_name_textview)
    TextView mNameTextView;
    @BindView(R.id.detail_language_textview)
    TextView mLanguageTextView;
    @BindView(R.id.detail_description_textview)
    TextView mDescriptionTextView;
    @BindView(R.id.detail_starred_textview)
    TextView mStarredTextView;
    @BindView(R.id.detail_forks_textview)
    TextView mForksTextView;
    @BindView(R.id.detail_watchers_textview)
    TextView mWatchersTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        loadViews((GitRepository) getIntent().getExtras().get("Repository"));
    }

    private void loadViews(GitRepository repository) {
        mOwnerTextView.setText(repository.getOwner().getLogin());
        mOwnerTypeTextView.setText(repository.getOwner().getType());

        mNameTextView.setText(repository.getFullName());
        mLanguageTextView.setText(repository.getLanguage());
        mDescriptionTextView.setText(repository.getDescription());
        mStarredTextView.setText(getString(R.string.detail_starred) + repository.getStarsCount());
        mForksTextView.setText(getString(R.string.detail_forked) + repository.getForks());
        mWatchersTextView.setText(getString(R.string.detail_watchers) + repository.getWatchersCount());
    }
}
