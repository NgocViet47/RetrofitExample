package com.example.mypc.retrofitexample.utils;

import android.content.Context;

import com.example.mypc.retrofitexample.model.StatusTicket;
import com.example.mypc.retrofitexample.realm.RealmStatus;

import java.util.List;

/**
 * Created by MyPC on 7/5/2017.
 */

public class StatusManager {
    public static List<StatusTicket> getAllStatusTicket(Context context){
       return RealmStatus.getStatusTicket(context);
    }
}
