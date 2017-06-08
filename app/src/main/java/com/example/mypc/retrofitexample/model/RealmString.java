package com.example.mypc.retrofitexample.model;

import io.realm.RealmObject;

/**
 * Created by MyPC on 5/31/2017.
 */

public class RealmString extends RealmObject {
    private String val;

    public RealmString() {
    }

    public RealmString(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
