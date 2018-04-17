package com.hanyasoftware.android.antrianbengkel.repository.entity.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BengkelResponse {
    @SerializedName("bng_id")
    @Expose
    private String bngId;
    @SerializedName("bng_nama")
    @Expose
    private String bngNama;
    @SerializedName("bng_alamat")
    @Expose
    private String bngAlamat;
    @SerializedName("bng_latitude")
    @Expose
    private String bngLatitude;
    @SerializedName("bng_longitude")
    @Expose
    private String bngLongitude;
    @SerializedName("bng_hari_buka")
    @Expose
    private String bngHariBuka;
    @SerializedName("bng_jam_buka")
    @Expose
    private String bngJamBuka;
    @SerializedName("bng_jam_tutup")
    @Expose
    private String bngJamTutup;
    @SerializedName("bng_ktg_id")
    @Expose
    private String bngKtgId;
    @SerializedName("ktg_id")
    @Expose
    private String ktgId;
    @SerializedName("ktg_nama")
    @Expose
    private String ktgNama;

    public String getBngId() {
        return bngId;
    }

    public void setBngId(String bngId) {
        this.bngId = bngId;
    }

    public String getBngNama() {
        return bngNama;
    }

    public void setBngNama(String bngNama) {
        this.bngNama = bngNama;
    }

    public String getBngAlamat() {
        return bngAlamat;
    }

    public void setBngAlamat(String bngAlamat) {
        this.bngAlamat = bngAlamat;
    }

    public String getBngLatitude() {
        return bngLatitude;
    }

    public void setBngLatitude(String bngLatitude) {
        this.bngLatitude = bngLatitude;
    }

    public String getBngLongitude() {
        return bngLongitude;
    }

    public void setBngLongitude(String bngLongitude) {
        this.bngLongitude = bngLongitude;
    }

    public String getBngHariBuka() {
        return bngHariBuka;
    }

    public void setBngHariBuka(String bngHariBuka) {
        this.bngHariBuka = bngHariBuka;
    }

    public String getBngJamBuka() {
        return bngJamBuka;
    }

    public void setBngJamBuka(String bngJamBuka) {
        this.bngJamBuka = bngJamBuka;
    }

    public String getBngJamTutup() {
        return bngJamTutup;
    }

    public void setBngJamTutup(String bngJamTutup) {
        this.bngJamTutup = bngJamTutup;
    }

    public String getBngKtgId() {
        return bngKtgId;
    }

    public void setBngKtgId(String bngKtgId) {
        this.bngKtgId = bngKtgId;
    }

    public String getKtgId() {
        return ktgId;
    }

    public void setKtgId(String ktgId) {
        this.ktgId = ktgId;
    }

    public String getKtgNama() {
        return ktgNama;
    }

    public void setKtgNama(String ktgNama) {
        this.ktgNama = ktgNama;
    }
}
