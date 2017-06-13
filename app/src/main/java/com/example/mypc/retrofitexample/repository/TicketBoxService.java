package com.example.mypc.retrofitexample.repository;

import com.example.mypc.retrofitexample.constan.ConstantApi;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by MyPC on 5/31/2017.
 */

public interface TicketBoxService {
    @FormUrlEncoded
    @POST(ConstantApi.LOGIN)
    Call<ResponseBody> login(@HeaderMap Map<String,String> headers,
                             @Field("email") String userName,
                             @Field("password") String password,
                             @Field("site_type") String site_type);
    @FormUrlEncoded
    @POST(ConstantApi.EVENTS)
    Call<ResponseBody> getEvents(@HeaderMap Map<String,String> headers,
                                 @Field("time_zone") String timeZone,
                                 @Field("last_sync_time") String lastSyncTime);

    @FormUrlEncoded
    @POST(ConstantApi.FORGOT_PASSWORD)
    Call<ResponseBody> resetPassword(@HeaderMap Map<String,String> headers,
                                     @Field("email") String userName,
                                     @Field("site_type") String site_type);

    @GET(ConstantApi.TICKET_STATUS)
    Call<ResponseBody> getStatusTicketbox(@HeaderMap Map<String,String> headers);

    @GET(ConstantApi.ORDER_STATUS)
    Call<ResponseBody> getStatusOrder(@HeaderMap Map<String,String> headers);

}

