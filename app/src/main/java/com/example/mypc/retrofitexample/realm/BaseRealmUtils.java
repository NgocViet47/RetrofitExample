package com.example.mypc.retrofitexample.realm;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by MyPC on 5/30/2017.
 */

public class BaseRealmUtils {
    private static final int REALM_VERSION =0;
    private static final String NAME_REALM_DEMO_MIGRATION = "DemoRetrofit.realm";
    public static RealmConfiguration getRealmConfig(Context context){
        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(NAME_REALM_DEMO_MIGRATION)
                .schemaVersion(REALM_VERSION)
                //.migration(new Migration())
                //.deleteRealmIfMigrationNeeded()
                .build();
        return config;
    }
}
