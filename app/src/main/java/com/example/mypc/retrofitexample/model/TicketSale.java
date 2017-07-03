package com.example.mypc.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 6/20/2017.
 */

public class TicketSale {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ticket_type_id")
    @Expose
    private Integer ticketTypeId;
    @SerializedName("ticket_type_name")
    @Expose
    private String ticketTypeName;
    @SerializedName("discount_code")
    @Expose
    private String discountCode;
    @SerializedName("total_sale")
    @Expose
    private Integer totalSale;
    @SerializedName("revenue")
    @Expose
    private Integer revenue;
    @SerializedName("paid_quantity")
    @Expose
    private Integer paidQuantity;
    @SerializedName("processing_quantity")
    @Expose
    private Integer processingQuantity;
    @SerializedName("cancel_quantity")
    @Expose
    private Integer cancelQuantity;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("service_fee")
    @Expose
    private Integer serviceFee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(Integer ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public String getTicketTypeName() {
        return ticketTypeName;
    }

    public void setTicketTypeName(String ticketTypeName) {
        this.ticketTypeName = ticketTypeName;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public Integer getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(Integer totalSale) {
        this.totalSale = totalSale;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Integer getPaidQuantity() {
        return paidQuantity;
    }

    public void setPaidQuantity(Integer paidQuantity) {
        this.paidQuantity = paidQuantity;
    }

    public Integer getProcessingQuantity() {
        return processingQuantity;
    }

    public void setProcessingQuantity(Integer processingQuantity) {
        this.processingQuantity = processingQuantity;
    }

    public Integer getCancelQuantity() {
        return cancelQuantity;
    }

    public void setCancelQuantity(Integer cancelQuantity) {
        this.cancelQuantity = cancelQuantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Integer serviceFee) {
        this.serviceFee = serviceFee;
    }
}
