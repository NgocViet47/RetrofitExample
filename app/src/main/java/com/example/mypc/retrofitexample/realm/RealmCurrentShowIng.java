package com.example.mypc.retrofitexample.realm;

import android.content.Context;

import com.example.mypc.retrofitexample.model.CurrentShowing;

import io.realm.Realm;
import io.realm.RealmResults;

import static com.example.mypc.retrofitexample.realm.BaseRealmUtils.getRealmConfig;

/**
 * Created by MyPC on 7/5/2017.
 */

public class RealmCurrentShowIng {
    private static Realm realm;

    public static void createCurrentShowIng(Context context, CurrentShowing currentShowing) {
        realm = Realm.getInstance(getRealmConfig(context));
        if (currentShowing != null) {
            realm.beginTransaction();
            realm.copyToRealm(currentShowing);
            realm.commitTransaction();
        }
    }
    public static CurrentShowing getListCurrentShowing(Context context) {
        realm = Realm.getInstance(getRealmConfig(context));
        return realm.where(CurrentShowing.class).findFirst();
    }
    public static void clearAllCurrentShowing(Context context){
        RealmResults<CurrentShowing> results = realm.where(CurrentShowing.class).findAll();
        realm.beginTransaction();
        results.deleteAllFromRealm();
        realm.commitTransaction();
    }
}
