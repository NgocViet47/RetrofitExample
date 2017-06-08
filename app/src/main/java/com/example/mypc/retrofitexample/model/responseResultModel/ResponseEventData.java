package com.example.mypc.retrofitexample.model.responseResultModel;

/**
 * Created by MyPC on 6/1/2017.
 */

import com.example.mypc.retrofitexample.model.Events;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseEventData {

    @SerializedName("last_sync_time")
    @Expose
    private String lastSyncTime;
    @SerializedName("events")
    @Expose
    private List<Events> events = null;
    @SerializedName("time_zone")
    @Expose
    private String timeZone;

    public String getLastSyncTime() {
        return lastSyncTime;
    }

    public void setLastSyncTime(String lastSyncTime) {
        this.lastSyncTime = lastSyncTime;
    }

    public List<Events> getEvents() {
        return events;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

}
