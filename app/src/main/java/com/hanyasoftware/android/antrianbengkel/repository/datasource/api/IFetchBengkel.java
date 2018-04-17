package com.hanyasoftware.android.antrianbengkel.repository.datasource.api;

import com.hanyasoftware.android.antrianbengkel.repository.entity.api.BengkelResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface IFetchBengkel {

    @GET("listbengkel")
    Single<List<BengkelResponse>> fetchAllBengkel();

}
