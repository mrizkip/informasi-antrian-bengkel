package com.hanyasoftware.android.antrianbengkel.repository.datasource.local;

import com.hanyasoftware.android.antrianbengkel.repository.datasource.api.IFetchBengkel;
import com.hanyasoftware.android.antrianbengkel.repository.entity.local.Bengkel;
import com.hanyasoftware.android.antrianbengkel.repository.transformer.BengkelResponseToBengkel;

import java.util.List;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;

public class BengkelRepository {

    private final IFetchBengkel iFetchBengkel;
    private final BengkelResponseToBengkel bengkelResponseToBengkel;

    @Inject
    public BengkelRepository(IFetchBengkel iFetchBengkel, BengkelResponseToBengkel bengkelResponseToBengkel) {
        this.iFetchBengkel = iFetchBengkel;
        this.bengkelResponseToBengkel = bengkelResponseToBengkel;
    }

    public Observable<List<Bengkel>> fetchAllBengkel() {
        return iFetchBengkel.fetchAllBengkel()
                .toObservable()
                .map(bengkelResponseToBengkel::transform)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
