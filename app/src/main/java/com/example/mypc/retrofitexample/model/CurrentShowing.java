package com.example.mypc.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by MyPC on 6/27/2017.
 */

public class CurrentShowing {
    @SerializedName("showing_id")
    @Expose
    private Integer showingId;
    @SerializedName("event_role_id")
    @Expose
    private Integer eventRoleId;
    @SerializedName("admin_role_id")
    @Expose
    private Integer adminRoleId;
    @SerializedName("tickets")
    @Expose
    private List<Ticket> tickets = null;
    @SerializedName("ticket_types")
    @Expose
    private List<TicketType> ticketTypes = null;
    @SerializedName("orders")
    @Expose
    private List<Order> orders = null;

    public Integer getShowingId() {
        return showingId;
    }

    public void setShowingId(Integer showingId) {
        this.showingId = showingId;
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<TicketType> getTicketTypes() {
        return ticketTypes;
    }

    public void setTicketTypes(List<TicketType> ticketTypes) {
        this.ticketTypes = ticketTypes;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
