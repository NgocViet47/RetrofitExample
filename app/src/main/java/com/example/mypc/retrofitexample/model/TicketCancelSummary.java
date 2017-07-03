package com.example.mypc.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 6/20/2017.
 */
public class TicketCancelSummary {
    @SerializedName("cod_count")
    @Expose
    private Integer codCount;
    @SerializedName("op_count")
    @Expose
    private Integer opCount;
    @SerializedName("bank_transfer_count")
    @Expose
    private Integer bankTransferCount;
    @SerializedName("payoo_count")
    @Expose
    private Integer payooCount;
    @SerializedName("others_count")
    @Expose
    private Integer othersCount;

    public Integer getCodCount() {
        return codCount;
    }

    public void setCodCount(Integer codCount) {
        this.codCount = codCount;
    }

    public Integer getOpCount() {
        return opCount;
    }

    public void setOpCount(Integer opCount) {
        this.opCount = opCount;
    }

    public Integer getBankTransferCount() {
        return bankTransferCount;
    }

    public void setBankTransferCount(Integer bankTransferCount) {
        this.bankTransferCount = bankTransferCount;
    }

    public Integer getPayooCount() {
        return payooCount;
    }

    public void setPayooCount(Integer payooCount) {
        this.payooCount = payooCount;
    }

    public Integer getOthersCount() {
        return othersCount;
    }

    public void setOthersCount(Integer othersCount) {
        this.othersCount = othersCount;
    }
}
