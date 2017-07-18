package com.example.mypc.retrofitexample.realm;

import io.realm.RealmObject;

/**
 * Created by MyPC on 7/4/2017.
 */

public class TicketR extends RealmObject {

    private Integer ticketId;
    private Integer ticketTypeId;
    private Integer eventId;
    private Integer showingId;
    private Integer orderId;
    private Integer userId;
    private String barcode;
    private Integer status;
    private String checkedInTime;

    public TicketR(){}

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(Integer ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getShowingId() {
        return showingId;
    }

    public void setShowingId(Integer showingId) {
        this.showingId = showingId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCheckedInTime() {
        return checkedInTime;
    }

    public void setCheckedInTime(String checkedInTime) {
        this.checkedInTime = checkedInTime;
    }
}
