package com.hanyasoftware.android.antrianbengkel.repository.transformer;

import com.hanyasoftware.android.antrianbengkel.main.BengkelAdapter;
import com.hanyasoftware.android.antrianbengkel.repository.entity.local.Bengkel;
import com.hanyasoftware.android.antrianbengkel.repository.ultils.BaseLayerDataTransformer;

import javax.inject.Inject;

public class BengkelToBengkelAdapter extends BaseLayerDataTransformer<Bengkel, BengkelAdapter> {

    @Inject
    public BengkelToBengkelAdapter() {
    }

    @Override
    public BengkelAdapter transform(Bengkel from) {
        BengkelAdapter data = new BengkelAdapter();
        data.setNamaBengkel(from.getBngNama());
        data.setIdBengkel(from.getBngId());
        data.setAlamatBengkel(from.getBngAlamat());
        data.setBngLatitude(from.getBngLatitude());
        data.setBngLongitude(from.getBngLongitude());
        data.setKategoriNama(from.getKtgNama());
        data.setBngHariBuka(from.getBngHariBuka());
        data.setBngJamBuka(from.getBngJamBuka());
        data.setBngJamTutup(from.getBngJamTutup());
        return data;
    }
}
