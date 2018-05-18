package com.hanyasoftware.android.antrianbengkel.repository.transformer;

import com.hanyasoftware.android.antrianbengkel.main.MotorAdapter;
import com.hanyasoftware.android.antrianbengkel.repository.entity.local.Motor;
import com.hanyasoftware.android.antrianbengkel.repository.ultils.BaseLayerDataTransformer;

import javax.inject.Inject;

public class MotorToAntrianAdapter extends BaseLayerDataTransformer<Motor, MotorAdapter> {

    @Inject
    public MotorToAntrianAdapter() {
    }

    @Override
    public MotorAdapter transform(Motor from) {
        MotorAdapter data = new MotorAdapter();
        data.setAntId(from.getAntId());
        data.setAntBngId(from.getAntBngId());
        data.setAntKendaraan(from.getAntKendaraan());
        data.setAntKendaraanNopol(from.getAntKendaraanNopol());
        data.setAntKendaraanPemilik(from.getAntKendaraanPemilik());
        data.setAntService(from.getAntService());
        data.setAntServiceDetail(from.getAntServiceDetail());
        data.setAntStatus(from.getAntStatus());
        data.setAntTanggal(from.getAntTanggal());
        data.setAntUrut(from.getAntUrut());
        return data;
    }
}
