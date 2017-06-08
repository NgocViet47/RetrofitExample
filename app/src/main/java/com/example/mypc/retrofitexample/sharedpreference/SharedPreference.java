package com.example.mypc.retrofitexample.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by MyPC on 6/5/2017.
 */

public class SharedPreference {
    private static final String DATA_NAME_SHAREDPREFERENCES = "myDataSharedPreferences";
    public static final String KEY_LAST_SYNC_TIME = "lastSyncTime";
    public static final String KEY_COUNTRY ="countryId" ;
    public static final String KEY_START_TIME ="startTime" ;

    public static void saveString(String mString,String key, Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(DATA_NAME_SHAREDPREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, mString);
        editor.commit();
    }
    public static String getString(String key,Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(DATA_NAME_SHAREDPREFERENCES, MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }

    public static void saveInteger(int mInteger,String key,Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(DATA_NAME_SHAREDPREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, mInteger);
        editor.commit();
    }

    public static Integer getInteger(String key,Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(DATA_NAME_SHAREDPREFERENCES, MODE_PRIVATE);
        return sharedPreferences.getInt(key,0);
    }

    public static void saveLong(Long mLong,String key,Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(DATA_NAME_SHAREDPREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, mLong);
        editor.commit();
    }

    public static long getLong(String key, Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(DATA_NAME_SHAREDPREFERENCES, MODE_PRIVATE);
        return sharedPreferences.getLong(key,0);
    }
}
