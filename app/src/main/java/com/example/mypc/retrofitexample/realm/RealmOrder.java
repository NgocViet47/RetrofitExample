package com.example.mypc.retrofitexample.realm;

import android.content.Context;

import com.example.mypc.retrofitexample.model.Order;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

import static com.example.mypc.retrofitexample.realm.BaseRealmUtils.getRealmConfig;

/**
 * Created by MyPC on 7/5/2017.
 */

public class RealmOrder {
    private static Realm realm;

    public static void createOrder(Context context, Order order) {
        realm = Realm.getInstance(getRealmConfig(context));
        if (order != null) {
            realm.beginTransaction();
            realm.copyToRealm(order);
            realm.commitTransaction();
        }
    }
    public static List<Order> getListOrder(Context context) {
        realm = Realm.getInstance(getRealmConfig(context));
        return realm.where(Order.class).findAll();
    }
    public static void clearAllOrder(Context context){
        realm = Realm.getInstance(getRealmConfig(context));
        RealmResults<Order> results = realm.where(Order.class).findAll();
        realm.beginTransaction();
        results.deleteAllFromRealm();
        realm.commitTransaction();
    }

}
