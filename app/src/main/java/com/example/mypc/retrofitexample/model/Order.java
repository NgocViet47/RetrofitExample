package com.example.mypc.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 6/27/2017.
 */

public class Order {
    @SerializedName("order_id")
    @Expose
    private Integer orderId;
    @SerializedName("event_id")
    @Expose
    private Integer eventId;
    @SerializedName("showing_id")
    @Expose
    private Integer showingId;
    @SerializedName("buyer_email")
    @Expose
    private String buyerEmail;
    @SerializedName("buyer_first_name")
    @Expose
    private String buyerFirstName;
    @SerializedName("buyer_last_name")
    @Expose
    private String buyerLastName;
    @SerializedName("buyer_phone_number")
    @Expose
    private String buyerPhoneNumber;
    @SerializedName("order_status")
    @Expose
    private Integer orderStatus;
    @SerializedName("created_date")
    @Expose
    private String createdDate;
    @SerializedName("ticket_quantity")
    @Expose
    private Integer ticketQuantity;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getBuyerFirstName() {
        return buyerFirstName;
    }

    public void setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
    }

    public String getBuyerLastName() {
        return buyerLastName;
    }

    public void setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
    }

    public String getBuyerPhoneNumber() {
        return buyerPhoneNumber;
    }

    public void setBuyerPhoneNumber(String buyerPhoneNumber) {
        this.buyerPhoneNumber = buyerPhoneNumber;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(Integer ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }
}
