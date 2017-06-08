package com.example.mypc.retrofitexample.model;

/**
 * Created by MyPC on 6/1/2017.
 */

import com.example.mypc.retrofitexample.model.dataEvent.Showing;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Events {

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
    @SerializedName("event_start_date")
    @Expose
    private String eventStartDate;
    @SerializedName("event_end_date")
    @Expose
    private String eventEndDate;
    @SerializedName("showings")
    @Expose
    private List<Showing> showings = null;
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

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public List<Showing> getShowings() {
        return showings;
    }

    public void setShowings(List<Showing> showing) {
        this.showings = showing;
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

}