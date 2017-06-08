package com.example.mypc.retrofitexample.repository;

import android.content.Context;

import com.example.mypc.retrofitexample.model.ResultResponse;
import com.example.mypc.retrofitexample.model.User;
import com.example.mypc.retrofitexample.model.responseResultModel.ResponseEventData;

import java.util.List;

/**
 * Created by MyPC on 5/31/2017.
 */

public interface TicketboxRepository {
    void login(final Context context, String email, String password, final CallBackData<User> callBackData);
    void getStatusTicketBox(final  Context context, final CallBackData<ResultResponse<List<Integer>>> callBackData);
    void getStatusOrder(final  Context context, final CallBackData<ResultResponse<List<Integer>>> callBackData);
    void getEvents(final Context context, String timeZone, String timeSync, CallBackData<ResultResponse<ResponseEventData>> callBackData);
}
