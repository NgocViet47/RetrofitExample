package com.example.mypc.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 6/20/2017.
 */
public class CashOnDelivery {
    @SerializedName("new_order")
    @Expose
    private Integer newOrder;
    @SerializedName("delivering")
    @Expose
    private Integer delivering;

    public Integer getNewOrder() {
        return newOrder;
    }

    public void setNewOrder(Integer newOrder) {
        this.newOrder = newOrder;
    }

    public Integer getDelivering() {
        return delivering;
    }

    public void setDelivering(Integer delivering) {
        this.delivering = delivering;
    }

}
