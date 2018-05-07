package com.hanyasoftware.android.antrianbengkel.repository.transformer;

import com.hanyasoftware.android.antrianbengkel.repository.entity.api.MotorResponse;
import com.hanyasoftware.android.antrianbengkel.repository.entity.local.Motor;
import com.hanyasoftware.android.antrianbengkel.repository.ultils.BaseLayerDataTransformer;

import javax.inject.Inject;

public class MotorResponseToMotor extends BaseLayerDataTransformer<MotorResponse, Motor> {

    @Inject
    public MotorResponseToMotor() {
    }

    @Override
    public Motor transform(MotorResponse from) {
        Motor motor = new Motor();
        motor.setAntBngId(from.getAntBngId());
        motor.setAntId(from.getAntId());
        motor.setAntKendaraan(from.getAntKendaraan());
        motor.setAntKendaraanNopol(from.getAntKendaraanNopol());
        motor.setAntKendaraanPemilik(from.getAntKendaraanPemilik());
        motor.setAntService(from.getAntService());
        motor.setAntServiceDetail(from.getAntServiceDetail());
        motor.setAntStatus(from.getAntStatus());
        motor.setAntTanggal(from.getAntTanggal());
        motor.setAntUrut(from.getAntUrut());
        return motor;
    }
}
