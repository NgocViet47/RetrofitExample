package com.example.mypc.retrofitexample.utils;

import android.content.Context;

import com.example.mypc.retrofitexample.model.Order;
import com.example.mypc.retrofitexample.realm.RealmOrder;

import java.util.List;

/**
 * Created by MyPC on 7/5/2017.
 */

public class OrderManager {
    public static void createOrder(Context context, Order order){
        RealmOrder.createOrder(context,order);
    }
    public static void clearAllOrder(Context context){
        RealmOrder.clearAllOrder(context);
    }
    public static List<Order> getListOrder(Context context){
        return RealmOrder.getListOrder(context);
    }
}
