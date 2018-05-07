package com.hanyasoftware.android.antrianbengkel.repository.entity.local;

import java.util.List;

public class AntrianBengkel {

    private int count;
    private List<Motor> list = null;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Motor> getList() {
        return list;
    }

    public void setList(List<Motor> list) {
        this.list = list;
    }
}
