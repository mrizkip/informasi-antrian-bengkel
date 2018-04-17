package com.hanyasoftware.android.antrianbengkel.main;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hanyasoftware.android.antrianbengkel.AntrianBengkelApplication;
import com.hanyasoftware.android.antrianbengkel.R;
import com.hanyasoftware.android.antrianbengkel.repository.entity.local.Bengkel;
import com.hanyasoftware.android.antrianbengkel.repository.transformer.BengkelToBengkelAdapter;
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

    private FastItemAdapter<BengkelAdapter> fastBengkelAdapter;
    private List<BengkelAdapter> bengkelAdapter;
    private List<Bengkel> bengkelList;

    private MainViewModel mainViewModel;
    private BengkelToBengkelAdapter bengkelToBengkelAdapter;

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

        mainViewModel = ViewModelProviders.of(this, AntrianBengkelApplication.getDataComponent()
                .getMainViewModelFactory()).get(MainViewModel.class);
        bengkelToBengkelAdapter = AntrianBengkelApplication.getMapperComponent().getBengkelToBengkelAdapter();

        bengkelAdapter = new ArrayList<>();
        fastBengkelAdapter = new FastItemAdapter<>();

        mainViewModel.getBengkelList().observe(this, bengkels -> {
            bengkelList = bengkels;
            bengkelAdapter = bengkelToBengkelAdapter.transform(bengkelList);

            fastBengkelAdapter.set(bengkelAdapter);

            recyclerViewBengkel.setLayoutManager(new LinearLayoutManager(this));
            recyclerViewBengkel.setAdapter(fastBengkelAdapter);

            fastBengkelAdapter.withSelectable(true);
            fastBengkelAdapter.withOnClickListener((v, adapter, item, position) -> {
                Intent intent = new Intent(v.getContext(), DetailBengkel.class);
                intent.putExtra("idBengkel", item.getIdBengkel());
                intent.putExtra("namaBengkel", item.getNamaBengkel());
                intent.putExtra("alamatBengkel", item.getAlamatBengkel());
                intent.putExtra("hariBuka", item.getBngHariBuka());
                intent.putExtra("jamBuka", item.getBngJamBuka());
                intent.putExtra("jamTutup", item.getBngJamTutup());
                intent.putExtra("longitude", item.getBngLongitude());
                intent.putExtra("latitude", item.getBngLatitude());
                startActivity(intent);
                return true;
            });
        });

    }
}
