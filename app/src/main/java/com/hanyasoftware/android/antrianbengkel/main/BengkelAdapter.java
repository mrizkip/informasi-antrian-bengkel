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

    private String namaBengkel;
    private String jalanBengkel;
    private String antrianBengkel;
    private String jarakBengkel;



    public String getNamaBengkel() {
        return namaBengkel;
    }

    public void setNamaBengkel(String namaBengkel) {
        this.namaBengkel = namaBengkel;
    }

    public String getJalanBengkel() {
        return jalanBengkel;
    }

    public void setJalanBengkel(String jalanBengkel) {
        this.jalanBengkel = jalanBengkel;
    }

    public String getAntrianBengkel() {
        return antrianBengkel;
    }

    public void setAntrianBengkel(String antrianBengkel) {
        this.antrianBengkel = antrianBengkel;
    }

    public String getJarakBengkel() {
        return jarakBengkel;
    }

    public void setJarakBengkel(String jarakBengkel) {
        this.jarakBengkel = jarakBengkel;
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

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindView(BengkelAdapter item, List<Object> payloads) {
            nama.setText(item.getNamaBengkel());
            jalan.setText(item.getJalanBengkel());
            jarak.setText(item.getJarakBengkel());
        }

        @Override
        public void unbindView(BengkelAdapter item) {
            nama.setText(null);
            jalan.setText(null);
            jarak.setText(null);
        }
    }
}
