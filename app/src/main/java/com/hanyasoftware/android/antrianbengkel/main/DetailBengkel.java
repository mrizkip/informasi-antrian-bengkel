package com.hanyasoftware.android.antrianbengkel.main;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.hanyasoftware.android.antrianbengkel.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailBengkel extends AppCompatActivity {

    @BindView(R.id.detailBengkel_buttonMaps)
    Button buttonMaps;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_bengkel);

        ButterKnife.bind(this);
        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Bengkel");
        }

        buttonMaps.setOnClickListener(view -> {
            double latitude = -7.938930;
            double longitude = 112.630280;
            String label = "AHASS 01734 Feko Motor";
            String uriBegin = "geo:" + latitude + "," + longitude;
            String query = latitude + "," + longitude + "(" + label + ")";
            String encodedQuery = Uri.encode(query);
            String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
            // Creates an Intent that will load a map of San Francisco
            Uri gmmIntentUri = Uri.parse(uriString);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });
    }
}
