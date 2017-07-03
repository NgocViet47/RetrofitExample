package com.example.mypc.retrofitexample.repository;

import android.content.Context;

import com.example.mypc.retrofitexample.model.responseResultModel.ResultResponse;
import com.example.mypc.retrofitexample.model.ShowingEvent;
import com.example.mypc.retrofitexample.model.User;
import com.example.mypc.retrofitexample.model.responseResultModel.ResponseEventData;
import com.example.mypc.retrofitexample.model.responseResultModel.ResponseOrderShowInData;
import com.example.mypc.retrofitexample.model.responseResultModel.ResponseReportData;

import java.util.List;

/**
 * Created by MyPC on 5/31/2017.
 */

public interface TicketboxRepository {
    void login(final Context context, String email, String password, final CallBackData<User> callBackData);
    void getStatusTicketBox(final  Context context, final CallBackData<ResultResponse<List<Integer>>> callBackData);
    void getStatusOrder(final  Context context, final CallBackData<ResultResponse<List<Integer>>> callBackData);
    void getEvents(final Context context, String timeZone, String timeSync, CallBackData<ResultResponse<ResponseEventData>> callBackData);
    void resetPassword(final Context context,String email);
    void getShowingByEventId(final Context context, Integer evnetId, String timeZone, CallBackData<ResultResponse<List<ShowingEvent>>> callBackData);
    void getRePorting(final Context context, Integer eventId, Integer showingId, String startDate, String endDate, String timeZone, CallBackData<ResultResponse<ResponseReportData>> callBackData);
    void getShowInOrder(final Context context,Integer showingId, String timeZone, CallBackData<ResultResponse<ResponseOrderShowInData>> callBackData);
}
