package com.example.mypc.retrofitexample.model;

import android.content.Context;

import com.example.mypc.retrofitexample.realm.RealmUser;
import com.example.mypc.retrofitexample.sharedpreference.SharedPreference;

/**
 * Created by MyPC on 5/31/2017.
 */

public class UserManager {
    public static String getAccessToken(Context context){
        return String.valueOf(RealmUser.getUser(context).getX_access_token());
    }
    public static String getXSiteId(Context context){
        return String.valueOf(SharedPreference.getInteger(SharedPreference.KEY_COUNTRY, context));
    }
    public static  String getLastSyncTime(Context context){
        return SharedPreference.getString(SharedPreference.KEY_LAST_SYNC_TIME,context);
    }
}
