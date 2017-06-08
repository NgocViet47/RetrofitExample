package com.example.mypc.retrofitexample.model.dataEvent;

/**
 * Created by MyPC on 6/1/2017.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Showing {

    @SerializedName("showing_id")
    @Expose
    private Integer showingId;
    @SerializedName("showing_start_date")
    @Expose
    private String showingStartDate;
    @SerializedName("showing_end_date")
    @Expose
    private String showingEndDate;
    @SerializedName("event_id")
    @Expose
    private Integer eventId;

    public Integer getShowingId() {
        return showingId;
    }

    public void setShowingId(Integer showingId) {
        this.showingId = showingId;
    }

    public String getShowingStartDate() {
        return showingStartDate;
    }

    public void setShowingStartDate(String showingStartDate) {
        this.showingStartDate = showingStartDate;
    }

    public String getShowingEndDate() {
        return showingEndDate;
    }

    public void setShowingEndDate(String showingEndDate) {
        this.showingEndDate = showingEndDate;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

}
