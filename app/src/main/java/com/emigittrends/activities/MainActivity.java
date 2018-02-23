package com.emigittrends.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.emigittrends.R;
import com.emigittrends.network.EmiHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmiHttpClient.getInstance().getHotRepositories();
    }
}
