package com.hanyasoftware.android.antrianbengkel.repository.datasource.api;

import com.hanyasoftware.android.antrianbengkel.repository.entity.api.BengkelResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IFetchBengkel {

    @FormUrlEncoded
    @POST("listbengkelwithradius")
    Single<List<BengkelResponse>> fetchAllBengkel(@Field("lat") String latitude,
                                                  @Field("long") String longitude,
                                                  @Field("radius") String radius);

}
