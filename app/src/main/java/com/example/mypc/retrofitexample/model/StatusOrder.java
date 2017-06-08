package com.example.mypc.retrofitexample.model;

import io.realm.RealmObject;

/**
 * Created by MyPC on 6/5/2017.
 */

public class StatusOrder extends RealmObject {
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
