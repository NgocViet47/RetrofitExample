package com.example.mypc.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 6/20/2017.
 */
public class SaleByDate {
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("paid_quantity")
    @Expose
    private Integer paidQuantity;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPaidQuantity() {
        return paidQuantity;
    }

    public void setPaidQuantity(Integer paidQuantity) {
        this.paidQuantity = paidQuantity;
    }

}
