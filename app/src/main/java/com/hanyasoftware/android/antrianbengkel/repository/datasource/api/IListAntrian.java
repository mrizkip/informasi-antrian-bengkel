package com.hanyasoftware.android.antrianbengkel.repository.datasource.api;

import com.hanyasoftware.android.antrianbengkel.repository.entity.api.AntrianResponse;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IListAntrian {

    @FormUrlEncoded
    @POST("listantrian")
    Single<AntrianResponse> fetchListAntrian(@Field("idbengkel") String idbengkel);
}
