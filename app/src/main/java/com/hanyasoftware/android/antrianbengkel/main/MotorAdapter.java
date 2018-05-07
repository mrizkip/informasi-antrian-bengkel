package com.hanyasoftware.android.antrianbengkel.main;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.hanyasoftware.android.antrianbengkel.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MotorAdapter extends AbstractItem<MotorAdapter, MotorAdapter.ViewHolder> {

    private String antId;
    private String antUrut;
    private String antTanggal;
    private String antService;
    private String antServiceDetail;
    private String antKendaraan;
    private String antKendaraanNopol;
    private String antKendaraanPemilik;
    private String antStatus;
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

    @NonNull
    @Override
    public MotorAdapter.ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.antrianAdapter_adapter;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_antrian_adapter;
    }

    protected static class ViewHolder extends FastAdapter.ViewHolder<MotorAdapter> {

        @BindView(R.id.antrianAdapter_nama)
        TextView kendaraan;
        @BindView(R.id.antrianAdapter_nomor)
        TextView nomor;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindView(MotorAdapter item, List<Object> payloads) {
            kendaraan.setText(item.getAntKendaraan());
            nomor.setText(item.getAntUrut());
        }

        @Override
        public void unbindView(MotorAdapter item) {
            kendaraan.setText(null);
            nomor.setText(null);
        }
    }
}
