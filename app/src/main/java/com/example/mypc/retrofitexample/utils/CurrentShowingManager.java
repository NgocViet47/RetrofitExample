package com.example.mypc.retrofitexample.utils;

import android.content.Context;

import com.example.mypc.retrofitexample.model.CurrentShowing;
import com.example.mypc.retrofitexample.realm.RealmCurrentShowIng;

/**
 * Created by MyPC on 7/5/2017.
 */

public class CurrentShowingManager {
    public static void createCurrentShowing(Context context,CurrentShowing currentShowing){
        RealmCurrentShowIng.createCurrentShowIng(context,currentShowing);
    }
    public static void clearAllCurrentShowing(Context context){
        RealmCurrentShowIng.clearAllCurrentShowing(context);
    }
    public static CurrentShowing getListCurrentShowing(Context context){
        return RealmCurrentShowIng.getListCurrentShowing(context);
    }
}
