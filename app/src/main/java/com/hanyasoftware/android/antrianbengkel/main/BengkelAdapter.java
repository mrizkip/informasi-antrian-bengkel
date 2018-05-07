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

public class BengkelAdapter extends AbstractItem<BengkelAdapter, BengkelAdapter.ViewHolder> {

    private String idBengkel;
    private String namaBengkel;
    private String alamatBengkel;
    private String antrianBengkel;
    private String bngLatitude;
    private String bngLongitude;
    private String kategoriNama;
    private String bngHariBuka;
    private String bngJamBuka;
    private String bngJamTutup;
    private String distance;

    public String getIdBengkel() {
        return idBengkel;
    }

    public void setIdBengkel(String idBengkel) {
        this.idBengkel = idBengkel;
    }

    public String getNamaBengkel() {
        return namaBengkel;
    }

    public void setNamaBengkel(String namaBengkel) {
        this.namaBengkel = namaBengkel;
    }

    public String getAlamatBengkel() {
        return alamatBengkel;
    }

    public void setAlamatBengkel(String alamatBengkel) {
        this.alamatBengkel = alamatBengkel;
    }

    public String getAntrianBengkel() {
        return antrianBengkel;
    }

    public void setAntrianBengkel(String antrianBengkel) {
        this.antrianBengkel = antrianBengkel;
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

    public String getKategoriNama() {
        return kategoriNama;
    }

    public void setKategoriNama(String kategoriNama) {
        this.kategoriNama = kategoriNama;
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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @NonNull
    @Override
    public BengkelAdapter.ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.itemBengkel_adapter;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_bengkel_adapter;
    }

    protected static class ViewHolder extends FastAdapter.ViewHolder<BengkelAdapter> {

        @BindView(R.id.itemBengkel_namaBengkel)
        TextView nama;
        @BindView(R.id.itemBengkel_jalan)
        TextView jalan;
        @BindView(R.id.itemBengkel_jarak)
        TextView jarak;
        @BindView(R.id.itemBengkel_merk)
        TextView merk;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindView(BengkelAdapter item, List<Object> payloads) {
            nama.setText(item.getNamaBengkel());
            jalan.setText(item.getAlamatBengkel());
            jarak.setText(item.getDistance() + " Km");
            if (item.getKategoriNama().equalsIgnoreCase("HONDA")) {
                merk.setText("HONDA");
                merk.setBackgroundResource(R.drawable.label_honda);
            } else if (item.getKategoriNama().equalsIgnoreCase("YAMAHA")){
                merk.setText("YAMAHA");
                merk.setBackgroundResource(R.drawable.label_yamaha);
            } else if (item.getKategoriNama().equalsIgnoreCase("SUZUKI")) {
                merk.setText("SUZUKI");
                merk.setBackgroundResource(R.drawable.label_suzuki);
            } else if (item.getKategoriNama().equalsIgnoreCase("KAWASAKI")) {
                merk.setText("KAWASAKI");
                merk.setBackgroundResource(R.drawable.label_kawasaki);
            } else {
                merk.setText("OTHER");
                merk.setBackgroundResource(R.drawable.label_other);
            }
        }

        @Override
        public void unbindView(BengkelAdapter item) {
            nama.setText(null);
            jalan.setText(null);
            jarak.setText(null);
        }
    }
}
