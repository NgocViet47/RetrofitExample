package com.example.mypc.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 6/20/2017.
 */

public class WaitingForPayment {
    @SerializedName("office_pickup")
    @Expose
    private Integer officePickup;
    @SerializedName("bank_transfer")
    @Expose
    private Integer bankTransfer;
    @SerializedName("convenient_store")
    @Expose
    private Integer convenientStore;
    @SerializedName("other")
    @Expose
    private Integer other;

    public Integer getOfficePickup() {
        return officePickup;
    }

    public void setOfficePickup(Integer officePickup) {
        this.officePickup = officePickup;
    }

    public Integer getBankTransfer() {
        return bankTransfer;
    }

    public void setBankTransfer(Integer bankTransfer) {
        this.bankTransfer = bankTransfer;
    }

    public Integer getConvenientStore() {
        return convenientStore;
    }

    public void setConvenientStore(Integer convenientStore) {
        this.convenientStore = convenientStore;
    }

    public Integer getOther() {
        return other;
    }

    public void setOther(Integer other) {
        this.other = other;
    }

}
