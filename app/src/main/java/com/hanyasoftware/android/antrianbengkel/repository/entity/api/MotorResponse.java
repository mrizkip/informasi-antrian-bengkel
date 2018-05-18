package com.hanyasoftware.android.antrianbengkel.repository.entity.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MotorResponse {
    @SerializedName("ant_id")
    @Expose
    private String antId;
    @SerializedName("ant_urut")
    @Expose
    private String antUrut;
    @SerializedName("ant_tanggal")
    @Expose
    private String antTanggal;
    @SerializedName("ant_service")
    @Expose
    private String antService;
    @SerializedName("ant_service_detail")
    @Expose
    private String antServiceDetail;
    @SerializedName("ant_kendaraan")
    @Expose
    private String antKendaraan;
    @SerializedName("ant_kendaraan_nopol")
    @Expose
    private String antKendaraanNopol;
    @SerializedName("ant_kendaraan_pemilik")
    @Expose
    private String antKendaraanPemilik;
    @SerializedName("ant_status")
    @Expose
    private String antStatus;
    @SerializedName("ant_bng_id")
    @Expose
    private String antBngId;

    public String getAntId() {
        return antId;
    }

    public void setAntId(String antId) {
        this.antId = antId;
    }

    public String getAntUrut() {
        return antUrut;
    }

    public void setAntUrut(String antUrut) {
        this.antUrut = antUrut;
    }

    public String getAntTanggal() {
        return antTanggal;
    }

    public void setAntTanggal(String antTanggal) {
        this.antTanggal = antTanggal;
    }

    public String getAntService() {
        return antService;
    }

    public void setAntService(String antService) {
        this.antService = antService;
    }

    public String getAntServiceDetail() {
        return antServiceDetail;
    }

    public void setAntServiceDetail(String antServiceDetail) {
        this.antServiceDetail = antServiceDetail;
    }

    public String getAntKendaraan() {
        return antKendaraan;
    }

    public void setAntKendaraan(String antKendaraan) {
        this.antKendaraan = antKendaraan;
    }

    public String getAntKendaraanNopol() {
        return antKendaraanNopol;
    }

    public void setAntKendaraanNopol(String antKendaraanNopol) {
        this.antKendaraanNopol = antKendaraanNopol;
    }

    public String getAntKendaraanPemilik() {
        return antKendaraanPemilik;
    }

    public void setAntKendaraanPemilik(String antKendaraanPemilik) {
        this.antKendaraanPemilik = antKendaraanPemilik;
    }

    public String getAntStatus() {
        return antStatus;
    }

    public void setAntStatus(String antStatus) {
        this.antStatus = antStatus;
    }

    public String getAntBngId() {
        return antBngId;
    }

    public void setAntBngId(String antBngId) {
        this.antBngId = antBngId;
    }
}
