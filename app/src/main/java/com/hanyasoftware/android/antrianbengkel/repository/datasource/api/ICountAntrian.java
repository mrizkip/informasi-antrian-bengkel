package com.hanyasoftware.android.antrianbengkel.repository.datasource.api;

import com.hanyasoftware.android.antrianbengkel.repository.entity.api.CountAntrianResponse;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ICountAntrian {

    @FormUrlEncoded
    @POST("countantrian")
    Single<CountAntrianResponse> countAntrian(@Field("idbengkel") String idbengkel);
}
