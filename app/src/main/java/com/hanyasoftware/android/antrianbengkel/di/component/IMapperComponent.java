package com.hanyasoftware.android.antrianbengkel.di.component;

import com.hanyasoftware.android.antrianbengkel.di.module.MapperModule;
import com.hanyasoftware.android.antrianbengkel.repository.transformer.AntrianResponseToAntrianBengkel;
import com.hanyasoftware.android.antrianbengkel.repository.transformer.BengkelResponseToBengkel;
import com.hanyasoftware.android.antrianbengkel.repository.transformer.BengkelToBengkelAdapter;
import com.hanyasoftware.android.antrianbengkel.repository.transformer.MotorResponseToMotor;
import com.hanyasoftware.android.antrianbengkel.repository.transformer.MotorToAntrianAdapter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MapperModule.class})
public interface IMapperComponent {

    BengkelResponseToBengkel getBengkelResponseToBengkel();

    BengkelToBengkelAdapter getBengkelToBengkelAdapter();

    MotorResponseToMotor getMotorResponseToMotor();

    AntrianResponseToAntrianBengkel getAntrianResponseToAntrianBengkel();

    MotorToAntrianAdapter getMotorToAntrianAdapter();
}
