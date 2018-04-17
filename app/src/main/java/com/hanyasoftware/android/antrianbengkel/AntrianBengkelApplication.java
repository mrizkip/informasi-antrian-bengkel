package com.hanyasoftware.android.antrianbengkel;

import android.app.Application;

import com.hanyasoftware.android.antrianbengkel.di.component.DaggerIAppComponent;
import com.hanyasoftware.android.antrianbengkel.di.component.DaggerIDataComponent;
import com.hanyasoftware.android.antrianbengkel.di.component.DaggerIMapperComponent;
import com.hanyasoftware.android.antrianbengkel.di.component.IAppComponent;
import com.hanyasoftware.android.antrianbengkel.di.component.IDataComponent;
import com.hanyasoftware.android.antrianbengkel.di.component.IMapperComponent;
import com.hanyasoftware.android.antrianbengkel.di.module.AppModule;
import com.hanyasoftware.android.antrianbengkel.di.module.DataModule;

public class AntrianBengkelApplication extends Application {

    private static IAppComponent applicationComponent;
    private static IDataComponent dataComponent;
    private static IMapperComponent mapperComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerIAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        dataComponent = DaggerIDataComponent.builder()
                .dataModule(new DataModule("http://samservis.hanyasoftware.com/api/"))
                .build();

        mapperComponent = DaggerIMapperComponent.create();
    }

    public static IAppComponent getApplicationComponent() { return applicationComponent; };
    public static IDataComponent getDataComponent() { return dataComponent; }
    public static IMapperComponent getMapperComponent() { return mapperComponent; }
}
