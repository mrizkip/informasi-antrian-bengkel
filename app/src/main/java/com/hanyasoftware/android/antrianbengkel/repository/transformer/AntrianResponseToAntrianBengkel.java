package com.hanyasoftware.android.antrianbengkel.repository.transformer;

import com.hanyasoftware.android.antrianbengkel.repository.entity.api.AntrianResponse;
import com.hanyasoftware.android.antrianbengkel.repository.entity.local.AntrianBengkel;
import com.hanyasoftware.android.antrianbengkel.repository.ultils.BaseLayerDataTransformer;

import javax.inject.Inject;

public class AntrianResponseToAntrianBengkel extends BaseLayerDataTransformer<AntrianResponse, AntrianBengkel> {

    private MotorResponseToMotor motorResponseToMotor;

    @Inject
    public AntrianResponseToAntrianBengkel(MotorResponseToMotor motorResponseToMotor) {
        this.motorResponseToMotor = motorResponseToMotor;
    }

    @Override
    public AntrianBengkel transform(AntrianResponse from) {
        AntrianBengkel data = new AntrianBengkel();
        data.setCount(from.getCount());
        data.setList(motorResponseToMotor.transform(from.getList()));
        return data;
    }
}
