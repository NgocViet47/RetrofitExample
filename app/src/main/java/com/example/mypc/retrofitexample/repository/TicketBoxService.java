package com.example.mypc.retrofitexample.repository;

import com.example.mypc.retrofitexample.constant.ConstantApi;
import com.example.mypc.retrofitexample.model.TicketCheck;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by MyPC on 5/31/2017.
 */

public interface TicketBoxService {
    @FormUrlEncoded
    @POST(ConstantApi.LOGIN)
    Call<ResponseBody> login(@HeaderMap Map<String, String> headers,
                             @Field("email") String userName,
                             @Field("password") String password,
                             @Field("site_type") String site_type);

    @FormUrlEncoded
    @POST(ConstantApi.EVENTS)
    Call<ResponseBody> getEvents(@HeaderMap Map<String, String> headers,
                                 @Field("time_zone") String timeZone,
                                 @Field("last_sync_time") String lastSyncTime);

    @FormUrlEncoded
    @POST(ConstantApi.FORGOT_PASSWORD)
    Call<ResponseBody> resetPassword(@HeaderMap Map<String, String> headers,
                                     @Field("email") String userName,
                                     @Field("site_type") String site_type);

    @FormUrlEncoded
    @POST(ConstantApi.SHOWINGS)
    Call<ResponseBody> getShowingByEventId(@HeaderMap Map<String, String> headers,
                                           @Field("event_id") Integer event_id,
                                           @Field("time_zone") String time_zone);

    @FormUrlEncoded
    @POST(ConstantApi.REPORTING)
    Call<ResponseBody> getRePorting(@Path("eventId") Integer eventId,
                                    @Path("showingId") Integer showingId,
                                    @HeaderMap Map<String, String> headers,
                                    @Field("time_zone") String time_zone
    );

    @FormUrlEncoded
    @POST(ConstantApi.SHOWING_SYNC)
    Call<ResponseBody> getShowInOrder(@Path("showingId") Integer showingId,
                                      @HeaderMap Map<String, String> headers,
                                      @Field("checked_in_tickets") Map<String, Integer> checkInTicket,
                                      @Field("undo_checked_in_tickets") Map<String, Integer> undoCheckInTicket,
                                      @Field("time_zone") String time_zone);

    @FormUrlEncoded
    @POST(ConstantApi.SHOWING_SYNC)
    Call<ResponseBody> postTicketNewCheckIn(@Path("showingId") Integer showingId,
                                           @HeaderMap Map<String, String> headers,
                                           @Field("checked_in_tickets[]")List<TicketCheck> checkList,
                                           @Field("undo_checked_in_tickets") Map<String, Integer> undoCheckInTicket,
                                           @Field("time_zone") String time_zone);

    @GET(ConstantApi.TICKET_STATUS)
    Call<ResponseBody> getStatusTicketbox(@HeaderMap Map<String, String> headers);

    @GET(ConstantApi.ORDER_STATUS)
    Call<ResponseBody> getStatusOrder(@HeaderMap Map<String, String> headers);

}

