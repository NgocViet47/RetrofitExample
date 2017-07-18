package com.example.mypc.retrofitexample.realm;

import android.content.Context;

import com.example.mypc.retrofitexample.model.TicketType;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

import static com.example.mypc.retrofitexample.realm.BaseRealmUtils.getRealmConfig;

/**
 * Created by MyPC on 7/5/2017.
 */

public class RealmTicketType {

    private static Realm realm;

    public static void createTicketType(Context context, TicketType ticket) {
        realm = Realm.getInstance(getRealmConfig(context));
        if (ticket != null) {
            realm.beginTransaction();
            realm.copyToRealm(ticket);
            realm.commitTransaction();
        }
    }
    public static List<TicketType> getListTicketType(Context context) {
        realm = Realm.getInstance(getRealmConfig(context));
        return realm.where(TicketType.class).findAll();
    }
    public static void clearAllTicketType(Context context){
        realm = Realm.getInstance(getRealmConfig(context));
        RealmResults<TicketType> results = realm.where(TicketType.class).findAll();
        realm.beginTransaction();
        results.deleteAllFromRealm();
        realm.commitTransaction();
    }

}
