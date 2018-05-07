package com.hanyasoftware.android.antrianbengkel.repository.datasource.local;

import com.hanyasoftware.android.antrianbengkel.repository.datasource.api.ICountAntrian;
import com.hanyasoftware.android.antrianbengkel.repository.datasource.api.IListAntrian;
import com.hanyasoftware.android.antrianbengkel.repository.entity.local.AntrianBengkel;
import com.hanyasoftware.android.antrianbengkel.repository.transformer.AntrianResponseToAntrianBengkel;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AntrianRepository {

    private final ICountAntrian iCountAntrian;
    private final IListAntrian iListAntrian;
    private final AntrianResponseToAntrianBengkel antrianResponseToAntrianBengkel;

    @Inject
    public AntrianRepository(ICountAntrian iCountAntrian, IListAntrian iListAntrian, AntrianResponseToAntrianBengkel antrianResponseToAntrianBengkel) {
        this.iCountAntrian = iCountAntrian;
        this.iListAntrian = iListAntrian;
        this.antrianResponseToAntrianBengkel = antrianResponseToAntrianBengkel;
    }

    public Observable<AntrianBengkel> fetchAntrianBengkel(String idBengkel) {
        return iListAntrian.fetchListAntrian(idBengkel)
                .toObservable()
                .map(antrianResponseToAntrianBengkel::transform)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
