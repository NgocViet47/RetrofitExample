package com.example.mypc.retrofitexample.realm;

import android.content.Context;

import com.example.mypc.retrofitexample.model.User;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

import static com.example.mypc.retrofitexample.realm.BaseRealmUtils.getRealmConfig;

/**
 * Created by MyPC on 5/31/2017.
 */

public class RealmUser {
    private static Realm realm;

    public static void createUser(Context context, User user) {
        realm = Realm.getInstance(getRealmConfig(context));
        if (user != null) {
            realm.beginTransaction();
            realm.copyToRealm(user);
            realm.commitTransaction();
        }
    }
    public static User getUser(Context context){
        realm = Realm.getInstance(getRealmConfig(context));
        RealmQuery<User> query = realm.where(User.class);
        return query.findFirst();
    }
    public static void clearUser(Context context){
        realm = Realm.getInstance(getRealmConfig(context));
        RealmResults<User> results = realm.where(User.class).findAll();
        realm.beginTransaction();
        results.deleteAllFromRealm();
        realm.commitTransaction();
    }
}
