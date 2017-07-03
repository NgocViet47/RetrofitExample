package com.example.mypc.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 6/20/2017.
 */

public class TicketProccessingSummary {
    @SerializedName("cash_on_delivery")
    @Expose
    private CashOnDelivery cashOnDelivery;
    @SerializedName("waiting_for_payment")
    @Expose
    private WaitingForPayment waitingForPayment;

    public CashOnDelivery getCashOnDelivery() {
        return cashOnDelivery;
    }

    public void setCashOnDelivery(CashOnDelivery cashOnDelivery) {
        this.cashOnDelivery = cashOnDelivery;
    }

    public WaitingForPayment getWaitingForPayment() {
        return waitingForPayment;
    }

    public void setWaitingForPayment(WaitingForPayment waitingForPayment) {
        this.waitingForPayment = waitingForPayment;
    }

}
