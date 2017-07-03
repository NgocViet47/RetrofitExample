package com.example.mypc.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 6/27/2017.
 */

public class Ticket {
    @SerializedName("ticket_id")
    @Expose
    private Integer ticketId;
    @SerializedName("ticket_type_id")
    @Expose
    private Integer ticketTypeId;
    @SerializedName("event_id")
    @Expose
    private Integer eventId;
    @SerializedName("showing_id")
    @Expose
    private Integer showingId;
    @SerializedName("order_id")
    @Expose
    private Integer orderId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("barcode")
    @Expose
    private String barcode;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("serial_number")
    @Expose
    private Integer serialNumber;
    @SerializedName("updated_date")
    @Expose
    private String updatedDate;
    @SerializedName("checked_in_time")
    @Expose
    private String checkedInTime;
    @SerializedName("seat_number")
    @Expose
    private Object seatNumber;
    @SerializedName("seat_section")
    @Expose
    private Object seatSection;
    @SerializedName("seat_row")
    @Expose
    private Object seatRow;
    @SerializedName("form_answer_sheet")
    @Expose
    private FormAnswerSheet formAnswerSheet;

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

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCheckedInTime() {
        return checkedInTime;
    }

    public void setCheckedInTime(String checkedInTime) {
        this.checkedInTime = checkedInTime;
    }

    public Object getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Object seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Object getSeatSection() {
        return seatSection;
    }

    public void setSeatSection(Object seatSection) {
        this.seatSection = seatSection;
    }

    public Object getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(Object seatRow) {
        this.seatRow = seatRow;
    }

    public FormAnswerSheet getFormAnswerSheet() {
        return formAnswerSheet;
    }

    public void setFormAnswerSheet(FormAnswerSheet formAnswerSheet) {
        this.formAnswerSheet = formAnswerSheet;
    }

}
