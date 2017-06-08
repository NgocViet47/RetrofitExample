package com.example.mypc.retrofitexample.model;

import io.realm.RealmObject;

/**
 * Created by VuPhan on 3/2/17.
 */

public class User extends RealmObject {

    private String x_access_token;
    private int user_id;
    private String first_name;
    private String last_name;
    private String avatar;
    private String email;
    private long expired_time;
    private boolean is_change_password;
    private String x_refresh_token;
    private long expired_time_refresh;


    public User() {
    }

    public String getX_access_token() {
        return x_access_token;
    }

    public void setX_access_token(String x_access_token) {
        this.x_access_token = x_access_token;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getExpired_time() {
        return expired_time;
    }

    public void setExpired_time(long expired_time) {
        this.expired_time = expired_time;
    }

    public boolean is_change_password() {
        return is_change_password;
    }

    public void setIs_change_password(boolean is_change_password) {
        this.is_change_password = is_change_password;
    }

    public String getX_refresh_token() {
        return x_refresh_token;
    }

    public void setX_refresh_token(String x_refresh_token) {
        this.x_refresh_token = x_refresh_token;
    }

    public long getExpired_time_refresh() {
        return expired_time_refresh;
    }

    public void setExpired_time_refresh(long expired_time_refresh) {
        this.expired_time_refresh = expired_time_refresh;
    }
}
