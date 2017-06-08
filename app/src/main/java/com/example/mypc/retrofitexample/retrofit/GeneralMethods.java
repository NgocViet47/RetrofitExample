package com.example.mypc.retrofitexample.retrofit;

import com.example.mypc.retrofitexample.model.RealmString;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.lang.reflect.Type;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.internal.IOException;

/**
 * Created by MyPC on 5/31/2017.
 */

public class GeneralMethods {
    public static Gson getGson() {

        Type token = new TypeToken<RealmList<RealmString>>() {
        }.getType();
        Gson gson = new GsonBuilder().serializeNulls()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                }).registerTypeAdapter(token, new TypeAdapter<RealmList<RealmString>>() {

                    @Override
                    public void write(JsonWriter out, RealmList<RealmString> value) throws IOException {
                        // Ignore
                    }

                    @Override
                    public RealmList<RealmString> read(JsonReader in) throws IOException {
                        RealmList<RealmString> list = new RealmList<RealmString>();
                        try {
                            in.beginArray();

                            while (in.hasNext()) {
                                list.add(new RealmString(in.nextString()));
                            }
                            in.endArray();
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                        return list;
                    }
                })
                .create();


        return gson;
    }

    public static Gson getGsonDefault(){
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();

        return gson;
    }
}
