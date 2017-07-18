package com.example.mypc.retrofitexample.utils;

import android.content.Context;

import com.example.mypc.retrofitexample.model.Ticket;
import com.example.mypc.retrofitexample.realm.RealmTicket;

import java.util.List;

/**
 * Created by MyPC on 7/5/2017.
 */

public class TicketManager {
    public static void createTicket(Context context, Ticket ticket) {
        RealmTicket.createTicket(context, ticket);
    }

    public static void clearAllTicket(Context context) {
        RealmTicket.clearAllTicket(context);
    }

    public static List<Ticket> getListTicket(Context context) {
        return RealmTicket.getListTicket(context);
    }
    public static void putTicket(Context context,String baseCode,String lastSyncTime){
        RealmTicket.putTicketCheckIn(context,baseCode,lastSyncTime);
    }
}
