package com.hanyasoftware.android.antrianbengkel.main;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.hanyasoftware.android.antrianbengkel.AntrianBengkelApplication;
import com.hanyasoftware.android.antrianbengkel.R;
import com.hanyasoftware.android.antrianbengkel.repository.entity.local.Bengkel;
import com.hanyasoftware.android.antrianbengkel.repository.entity.local.Motor;
import com.hanyasoftware.android.antrianbengkel.repository.transformer.MotorToAntrianAdapter;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailBengkel extends AppCompatActivity {

    private static final String TAG = "DetailBengkel";

    @BindView(R.id.detailBengkel_buttonMaps)
    Button buttonMaps;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.detailBengkel_jumlahAntrian)
    TextView jumlahAntrian;
    @BindView(R.id.detailBengkel_recyclerViewAntrian)
    RecyclerView recyclerView;
    @BindView(R.id.detailBengkel_alamat)
    TextView alamat;
    ActionBar actionBar;

    private Bengkel bengkel;
    private DetailBengkelViewModel viewModel;
    private MotorToAntrianAdapter motorToAntrianAdapter;
    private int countAntrian;
    private List<Motor> motorList;

    private FastItemAdapter<MotorAdapter> fastItemAdapter;
    private List<MotorAdapter> motorAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_bengkel);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        bengkel = new Bengkel();
        bengkel.setBngId(intent.getStringExtra("idBengkel"));
        bengkel.setBngNama(intent.getStringExtra("namaBengkel"));
        bengkel.setBngAlamat(intent.getStringExtra("alamatBengkel"));
        bengkel.setBngLatitude(intent.getStringExtra("latitude"));
        bengkel.setBngLongitude(intent.getStringExtra("longitude"));
        bengkel.setBngHariBuka(intent.getStringExtra("hariBuka"));
        bengkel.setBngJamBuka(intent.getStringExtra("jamBuka"));
        bengkel.setBngJamTutup(intent.getStringExtra("jamTutup"));

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle(bengkel.getBngNama());
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        viewModel = ViewModelProviders.of(this, AntrianBengkelApplication.getDataComponent()
                .getDetailBengkelViewModelFactory()).get(DetailBengkelViewModel.class);
        motorToAntrianAdapter = AntrianBengkelApplication.getMapperComponent().getMotorToAntrianAdapter();
        fastItemAdapter = new FastItemAdapter<>();
        motorList = new ArrayList<>();
        motorAdapters = new ArrayList<>();

        // set alamat
        alamat.setText(bengkel.getBngAlamat());

        // set dialog fil

        // fetch antrian
        viewModel.getAntrianBengkel(bengkel.getBngId()).observe(this, antrian -> {
            if (antrian != null) {
                countAntrian = antrian.getCount();
                motorList = antrian.getList();
                jumlahAntrian.setText(String.valueOf(countAntrian));
                Log.d(TAG, "onCreate: motorList " + motorList.size());
            }

            if (countAntrian > 0) {
                motorAdapters = motorToAntrianAdapter.transform(motorList);
                Log.d(TAG, "onCreate: Motor adapter " + motorAdapters.size());
                fastItemAdapter.set(motorAdapters);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(fastItemAdapter);
            }
        });

        // button maps
        buttonMaps.setOnClickListener(view -> {
            String latitude = bengkel.getBngLatitude();
            String longitude = bengkel.getBngLongitude();
            String label = bengkel.getBngNama();
            String uriBegin = "geo:" + latitude + "," + longitude;
            String query = latitude + "," + longitude + "(" + label + ")";
            String encodedQuery = Uri.encode(query);
            String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
            // Creates an Intent that will load a map
            Uri gmmIntentUri = Uri.parse(uriString);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
