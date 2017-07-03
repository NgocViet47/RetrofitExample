package com.example.mypc.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 6/15/2017.
 */

public class ShowingEvent {
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
    @SerializedName("event_name")
    @Expose
    private String eventName;
    @SerializedName("event_logo_url")
    @Expose
    private String eventLogoUrl;
    @SerializedName("event_cover_image_url")
    @Expose
    private String eventCoverImageUrl;
    @SerializedName("venue_title")
    @Expose
    private String venueTitle;
    @SerializedName("venue_full_address")
    @Expose
    private String venueFullAddress;
    @SerializedName("event_role_id")
    @Expose
    private Integer eventRoleId;
    @SerializedName("admin_role_id")
    @Expose
    private Integer adminRoleId;
    @SerializedName("time_zone")
    @Expose
    private String timeZone;

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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLogoUrl() {
        return eventLogoUrl;
    }

    public void setEventLogoUrl(String eventLogoUrl) {
        this.eventLogoUrl = eventLogoUrl;
    }

    public String getEventCoverImageUrl() {
        return eventCoverImageUrl;
    }

    public void setEventCoverImageUrl(String eventCoverImageUrl) {
        this.eventCoverImageUrl = eventCoverImageUrl;
    }

    public String getVenueTitle() {
        return venueTitle;
    }

    public void setVenueTitle(String venueTitle) {
        this.venueTitle = venueTitle;
    }

    public String getVenueFullAddress() {
        return venueFullAddress;
    }

    public void setVenueFullAddress(String venueFullAddress) {
        this.venueFullAddress = venueFullAddress;
    }

    public Integer getEventRoleId() {
        return eventRoleId;
    }

    public void setEventRoleId(Integer eventRoleId) {
        this.eventRoleId = eventRoleId;
    }

    public Integer getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(Integer adminRoleId) {
        this.adminRoleId = adminRoleId;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
