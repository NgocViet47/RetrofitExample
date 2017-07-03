package com.example.mypc.retrofitexample.model.responseResultModel;

import com.example.mypc.retrofitexample.model.CurrentShowing;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 6/27/2017.
 */

public class ResponseOrderShowInData {
    @SerializedName("last_sync_time")
    @Expose
    private String lastSyncTime;
    @SerializedName("current_showing")
    @Expose
    private CurrentShowing currentShowing;
    @SerializedName("season_showing")
    @Expose
    private Object seasonShowing;

    public String getLastSyncTime() {
        return lastSyncTime;
    }

    public void setLastSyncTime(String lastSyncTime) {
        this.lastSyncTime = lastSyncTime;
    }

    public CurrentShowing getCurrentShowing() {
        return currentShowing;
    }

    public void setCurrentShowing(CurrentShowing currentShowing) {
        this.currentShowing = currentShowing;
    }

    public Object getSeasonShowing() {
        return seasonShowing;
    }

    public void setSeasonShowing(Object seasonShowing) {
        this.seasonShowing = seasonShowing;
    }
}
