package com.example.mypc.retrofitexample.repository;

/**
 * Created by VuPhan on 9/3/16.
 */
public interface CallBackData<T> {

    void onResponseData(T t);
    void onFailed(String message);
}
