package com.hanyasoftware.android.antrianbengkel.main;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hanyasoftware.android.antrianbengkel.R;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;
import com.mikepenz.fastadapter.listeners.OnClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.main_recycleView)
    RecyclerView recyclerViewBengkel;
    ActionBar actionBar;

    FastItemAdapter<BengkelAdapter> fastBengkelAdapter;
    List<BengkelAdapter> bengkelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Antrian Bengkel");
        }

        BengkelAdapter bengkel = new BengkelAdapter();
        bengkel.setNamaBengkel("Bengkel 1");
        bengkel.setJalanBengkel("Jalan Bengkel 1");
        bengkel.setAntrianBengkel("10");
        bengkel.setJarakBengkel("1 Km");

        BengkelAdapter bengkel2 = new BengkelAdapter();
        bengkel2.setNamaBengkel("Bengkel 1");
        bengkel2.setJalanBengkel("Jalan Bengkel 1");
        bengkel2.setAntrianBengkel("10");
        bengkel2.setJarakBengkel("1 Km");

        bengkelAdapter = new ArrayList<>();
        bengkelAdapter.add(bengkel);
        bengkelAdapter.add(bengkel2);
        fastBengkelAdapter = new FastItemAdapter<>();

        fastBengkelAdapter.set(bengkelAdapter);

        recyclerViewBengkel.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewBengkel.setAdapter(fastBengkelAdapter);

        fastBengkelAdapter.withSelectable(true);
        fastBengkelAdapter.withOnClickListener(new OnClickListener<BengkelAdapter>() {
            @Override
            public boolean onClick(@Nullable View v, IAdapter<BengkelAdapter> adapter, BengkelAdapter item, int position) {
                Intent intent = new Intent(v.getContext(), DetailBengkel.class);
                startActivity(intent);
                return true;
            }
        });


    }
}
