package com.example.mypc.retrofitexample.model;

/**
 * Created by MyPC on 6/27/2017.
 */

public class OrderAndNumberTicket {
    private Order order;
    private Integer numberTicket;

    public OrderAndNumberTicket(Order order, Integer numberTicket) {
        this.order = order;
        this.numberTicket = numberTicket;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getNumberTicket() {
        return numberTicket;
    }

    public void setNumberTicket(Integer numberTicket) {
        this.numberTicket = numberTicket;
    }
}

