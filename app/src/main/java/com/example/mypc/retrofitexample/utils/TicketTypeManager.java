package com.example.mypc.retrofitexample.utils;

import android.content.Context;

import com.example.mypc.retrofitexample.model.TicketType;
import com.example.mypc.retrofitexample.realm.RealmTicketType;

import java.util.List;

/**
 * Created by MyPC on 7/5/2017.
 */

public class TicketTypeManager {
    public static void createTicketType(Context context, TicketType ticket){
        RealmTicketType.createTicketType(context,ticket);
    }
    public static void clearAllTicketType(Context context){
        RealmTicketType.clearAllTicketType(context);
    }
    public static List<TicketType> getListTicketType(Context context){
        return RealmTicketType.getListTicketType(context);
    }
}
