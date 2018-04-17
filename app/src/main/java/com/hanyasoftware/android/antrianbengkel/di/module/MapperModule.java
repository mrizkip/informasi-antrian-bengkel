package com.hanyasoftware.android.antrianbengkel.di.module;

import com.hanyasoftware.android.antrianbengkel.repository.transformer.BengkelResponseToBengkel;
import com.hanyasoftware.android.antrianbengkel.repository.transformer.BengkelToBengkelAdapter;

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

}
