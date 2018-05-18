package com.hanyasoftware.android.antrianbengkel.repository.entity.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AntrianResponse {
    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("list")
    @Expose
    private List<MotorResponse> list = null;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<MotorResponse> getList() {
        return list;
    }

    public void setList(List<MotorResponse> list) {
        this.list = list;
    }
}
