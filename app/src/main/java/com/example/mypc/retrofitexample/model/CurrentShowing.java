package com.example.mypc.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by MyPC on 6/27/2017.
 */

public class CurrentShowing extends RealmObject{
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
    private RealmList<Ticket> tickets = null;
    @SerializedName("ticket_types")
    @Expose
    private RealmList<TicketType> ticketTypes = null;
    @SerializedName("orders")
    @Expose
    private RealmList<Order> orders = null;

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

    public void setTickets(RealmList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<TicketType> getTicketTypes() {
        return ticketTypes;
    }

    public void setTicketTypes(RealmList<TicketType> ticketTypes) {
        this.ticketTypes = ticketTypes;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(RealmList<Order> orders) {
        this.orders = orders;
    }
}
