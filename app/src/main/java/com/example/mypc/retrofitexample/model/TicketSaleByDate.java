package com.example.mypc.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by MyPC on 6/20/2017.
 */

public class TicketSaleByDate {
    @SerializedName("ticket_type_id")
    @Expose
    private Integer ticketTypeId;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("sale_by_dates")
    @Expose
    private List<SaleByDate> saleByDates = null;

    public Integer getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(Integer ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<SaleByDate> getSaleByDates() {
        return saleByDates;
    }

    public void setSaleByDates(List<SaleByDate> saleByDates) {
        this.saleByDates = saleByDates;
    }
}
