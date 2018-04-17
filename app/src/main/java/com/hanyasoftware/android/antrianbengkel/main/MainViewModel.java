package com.hanyasoftware.android.antrianbengkel.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.hanyasoftware.android.antrianbengkel.repository.datasource.local.BengkelRepository;
import com.hanyasoftware.android.antrianbengkel.repository.entity.local.Bengkel;

import java.util.List;

import javax.inject.Inject;

import retrofit2.adapter.rxjava2.Result;

public class MainViewModel extends ViewModel {

    private final BengkelRepository bengkelRepository;
    private final MutableLiveData<List<Bengkel>> listBenkel;

    public MainViewModel(BengkelRepository bengkelRepository) {
        this.bengkelRepository = bengkelRepository;
        listBenkel = new MutableLiveData<>();

        fetchAllBengkel();
    }

    private void fetchAllBengkel() {
        bengkelRepository.fetchAllBengkel()
                .subscribe(bengkels -> {
                    this.listBenkel.postValue(bengkels);
                }, throwable -> {

                });
    }

    public LiveData<List<Bengkel>> getBengkelList() {
        return listBenkel;
    }

    public static class MainViewModelFactory implements ViewModelProvider.Factory {

        private final BengkelRepository bengkelRepository;

        @Inject
        public MainViewModelFactory(BengkelRepository bengkelRepository) {
            this.bengkelRepository = bengkelRepository;
        }


        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new MainViewModel(bengkelRepository);
        }
    }


}
