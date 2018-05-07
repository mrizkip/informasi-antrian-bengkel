package com.hanyasoftware.android.antrianbengkel.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.util.Log;

import com.hanyasoftware.android.antrianbengkel.repository.datasource.local.AntrianRepository;
import com.hanyasoftware.android.antrianbengkel.repository.entity.local.AntrianBengkel;
import com.hanyasoftware.android.antrianbengkel.repository.entity.local.Motor;

import java.util.List;

import javax.inject.Inject;

public class DetailBengkelViewModel extends ViewModel {

    private static final String TAG = "DetailBengkelViewModel";

    private final AntrianRepository antrianRepository;
    private MutableLiveData<AntrianBengkel> antrianBengkel;

    public DetailBengkelViewModel(AntrianRepository antrianRepository) {
        this.antrianRepository = antrianRepository;
        antrianBengkel = new MutableLiveData<>();
    }

    public LiveData<AntrianBengkel> getAntrianBengkel(String idBengkel) {
        antrianRepository.fetchAntrianBengkel(idBengkel)
                .subscribe(bengkel -> {
                    Log.d(TAG, "getAntrianBengkel: " + bengkel.getCount());
                    antrianBengkel.postValue(bengkel);
                }, throwable -> {
                    AntrianBengkel bengkel1 = new AntrianBengkel();
                    bengkel1.setCount(0);
                    bengkel1.setList(null);
                    antrianBengkel.postValue(bengkel1);
                });
        return antrianBengkel;
    }

    public static class DetailBengkelViewModelFactory implements ViewModelProvider.Factory {

        private final AntrianRepository antrianRepository;

        @Inject
        public DetailBengkelViewModelFactory(AntrianRepository antrianRepository) {
            this.antrianRepository = antrianRepository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new DetailBengkelViewModel(antrianRepository);
        }
    }


}
