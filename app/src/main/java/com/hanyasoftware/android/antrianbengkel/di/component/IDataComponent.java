package com.hanyasoftware.android.antrianbengkel.di.component;

import com.hanyasoftware.android.antrianbengkel.di.module.DataModule;
import com.hanyasoftware.android.antrianbengkel.main.MainViewModel;
import com.hanyasoftware.android.antrianbengkel.repository.datasource.local.BengkelRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DataModule.class})
public interface IDataComponent {

    BengkelRepository getBengkelRepository();

    MainViewModel.MainViewModelFactory getMainViewModelFactory();
}
