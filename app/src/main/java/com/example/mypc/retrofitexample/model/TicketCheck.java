package com.example.mypc.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 7/6/2017.
 */

public class TicketCheck {

    @SerializedName("ticket_id")
    @Expose
    private Integer ticket_id;

    @SerializedName("checked_in_time")
    @Expose
    private String checked_in_time;

    public Integer getTicketId() {
        return ticket_id;
    }

    public void setTicketId(Integer ticketId) {
        this.ticket_id = ticketId;
    }

    public String getTimeCheckIn() {
        return checked_in_time;
    }

    public void setTimeCheckIn(String timeCheckIn) {
        this.checked_in_time = timeCheckIn;
    }
}
