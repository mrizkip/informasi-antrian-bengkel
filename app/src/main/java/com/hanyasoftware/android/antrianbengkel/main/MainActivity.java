package com.hanyasoftware.android.antrianbengkel.main;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.hanyasoftware.android.antrianbengkel.AntrianBengkelApplication;
import com.hanyasoftware.android.antrianbengkel.R;
import com.hanyasoftware.android.antrianbengkel.repository.entity.local.Bengkel;
import com.hanyasoftware.android.antrianbengkel.repository.transformer.BengkelToBengkelAdapter;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

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

    private DialogMerkUtil dialogMerkUtil;
    private List<Bengkel> selectedItems;
    private List<String> arrayString;

    private boolean flagGps = false;

    private String latitude;
    private String longitude;

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
        selectedItems = new ArrayList<>();
        arrayString = new ArrayList<>();
        fastBengkelAdapter = new FastItemAdapter<>();
        dialogMerkUtil = new DialogMerkUtil(this);

        // set dialog
        dialogMerkUtil.setOnOkSelected(this::filterItems);

        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            flagGps = showGpsStatus();
                            if (flagGps) {
                                // get location and fetch bengkel
                                getLocation(MainActivity.this);
                            }
                        } else if (report.isAnyPermissionPermanentlyDenied()) {
                            Toast.makeText(MainActivity.this, "Izinkan semua permission untuk menggunakan aplikasi ini!", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

                    }
                }).check();

    }

    private void filterItems() {
        selectedItems.clear();
        arrayString = dialogMerkUtil.getArraySelected();
        if (arrayString.size() > 0 && bengkelList.size() > 0) {
            for (Bengkel bengkel : bengkelList) {
                for (int i = 0; i < arrayString.size(); i++) {
                    if (bengkel.getKtgNama().equalsIgnoreCase(arrayString.get(i))) {
                        selectedItems.add(bengkel);
                    }
                }
            }
        }
        if (selectedItems.size() > 0) {
            List<BengkelAdapter> bengkelSelected = new ArrayList<>();
            bengkelSelected = bengkelToBengkelAdapter.transform(selectedItems);
            fastBengkelAdapter.set(bengkelSelected);
        } else {
            bengkelAdapter = bengkelToBengkelAdapter.transform(bengkelList);
            fastBengkelAdapter.set(bengkelAdapter);
        }
    }

    private void fetchBengkel() {
        mainViewModel.getBengkelList(latitude, longitude).observe(this, bengkels -> {
            bengkelList = bengkels;
            bengkelAdapter = bengkelToBengkelAdapter.transform(bengkelList);

            fastBengkelAdapter.set(bengkelAdapter);

            recyclerViewBengkel.setLayoutManager(new LinearLayoutManager(this));
            recyclerViewBengkel.setAdapter(fastBengkelAdapter);

            fastBengkelAdapter.withSelectable(true);
            fastBengkelAdapter.withOnClickListener((v, adapter, item, position) -> {
                intentOnCLickListener(item);
                return true;
            });
        });
    }

    private void intentOnCLickListener(BengkelAdapter item) {
        Intent intent = new Intent(MainActivity.this, DetailBengkel.class);
        intent.putExtra("idBengkel", item.getIdBengkel());
        intent.putExtra("namaBengkel", item.getNamaBengkel());
        intent.putExtra("alamatBengkel", item.getAlamatBengkel());
        intent.putExtra("hariBuka", item.getBngHariBuka());
        intent.putExtra("jamBuka", item.getBngJamBuka());
        intent.putExtra("jamTutup", item.getBngJamTutup());
        intent.putExtra("longitude", item.getBngLongitude());
        intent.putExtra("latitude", item.getBngLatitude());
        startActivity(intent);
    }


    private void getLocation(Context context) {
        SingleShotLocationProvider.requestSingleUpdate(context,
                location -> {
                    latitude = String.valueOf(location.latitude);
                    longitude = String.valueOf(location.longitude);
                    fetchBengkel();
                });
    }

    private boolean showGpsStatus() {
        ContentResolver contentResolver = getBaseContext()
                .getContentResolver();
        return Settings.Secure
                .isLocationProviderEnabled(contentResolver,
                        LocationManager.GPS_PROVIDER);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        MenuItem filter = menu.findItem(R.id.menuMain_filter);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuMain_filter:
                dialogMerkUtil.setArraySelected(arrayString);
                dialogMerkUtil.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
