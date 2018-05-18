package com.hanyasoftware.android.antrianbengkel.di.module;

import com.hanyasoftware.android.antrianbengkel.repository.transformer.AntrianResponseToAntrianBengkel;
import com.hanyasoftware.android.antrianbengkel.repository.transformer.BengkelResponseToBengkel;
import com.hanyasoftware.android.antrianbengkel.repository.transformer.BengkelToBengkelAdapter;
import com.hanyasoftware.android.antrianbengkel.repository.transformer.MotorResponseToMotor;
import com.hanyasoftware.android.antrianbengkel.repository.transformer.MotorToAntrianAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MapperModule {

    @Provides
    @Singleton
    BengkelResponseToBengkel provideBengkelResponseToBengkel() {
        return new BengkelResponseToBengkel();
    }

    @Provides
    @Singleton
    BengkelToBengkelAdapter provideBengkelToBengkelAdapter() {
        return new BengkelToBengkelAdapter();
    }

    @Provides
    @Singleton
    MotorResponseToMotor provideMotorResponseToMotor() {
        return new MotorResponseToMotor();
    }

    @Provides
    @Singleton
    AntrianResponseToAntrianBengkel provideAntrianResponseToAntrianBengkel(MotorResponseToMotor motorResponseToMotor) {
        return new AntrianResponseToAntrianBengkel(motorResponseToMotor);
    }

    @Provides
    @Singleton
    MotorToAntrianAdapter provideMotorToAntrianAdapter() {
        return new MotorToAntrianAdapter();
    }

}
