package com.example.mypc.retrofitexample.realm;

import android.content.Context;

import com.example.mypc.retrofitexample.model.StatusOrder;
import com.example.mypc.retrofitexample.model.StatusTicket;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

import static com.example.mypc.retrofitexample.realm.BaseRealmUtils.getRealmConfig;

/**
 * Created by MyPC on 6/5/2017.
 */

public class RealmStatus {
    private static Realm realm;

    public static void createStatusTicket(Context context, StatusTicket statusTicket) {
        realm = Realm.getInstance(getRealmConfig(context));
        if (statusTicket != null) {
            realm.beginTransaction();
            realm.copyToRealm(statusTicket);
            realm.commitTransaction();
        }
    }

    public static List<StatusTicket> getStatusTicket(Context context) {
        realm = Realm.getInstance(getRealmConfig(context));
        return realm.where(StatusTicket.class).findAll();
    }

    public static void clearAllStatusTicket(Context context){
        RealmResults<StatusTicket> results = realm.where(StatusTicket.class).findAll();
        realm.beginTransaction();
        results.deleteAllFromRealm();
        realm.commitTransaction();
    }

    public static void createStatusOrder(Context context, StatusOrder statusOrder) {
        realm = Realm.getInstance(getRealmConfig(context));
        if (statusOrder != null) {
            realm.beginTransaction();
            realm.copyToRealm(statusOrder);
            realm.commitTransaction();
        }
    }

    public static List<StatusOrder> getStatusOrder(Context context) {
        realm = Realm.getInstance(getRealmConfig(context));
        return realm.where(StatusOrder.class).findAll();
    }
}
