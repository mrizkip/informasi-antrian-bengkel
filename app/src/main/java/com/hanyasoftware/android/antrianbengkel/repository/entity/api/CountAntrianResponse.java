package com.hanyasoftware.android.antrianbengkel.repository.entity.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountAntrianResponse {

    @SerializedName("antrian")
    @Expose
    private int antrian;

    public int getAntrian() {
        return antrian;
    }

    public void setAntrian(int antrian) {
        this.antrian = antrian;
    }
}
