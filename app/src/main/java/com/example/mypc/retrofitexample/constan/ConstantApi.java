package com.example.mypc.retrofitexample.constan;

/**
 * Created by VuPhan on 3/2/17.
 */

public class ConstantApi {

    public static final String BASE_URL = "http://103.199.8.29:3005";
    public static final String LOGIN = "/api/v1/users/signin";
    public static final String LOGIN_FACEBOOK = "/api/v1/users/facebook";
    public static final String FORGOT_PASSWORD = "/api/v1/users/resetpassword";
    public static final String EVENTS ="/api/v1/events";
    public static final String SHOWINGS = "/api/v1/showings";
    public static final String SHOWING_SYNC = "/api/v1/showings/{showingId}/sync";
    public static final String TOKEN = "/api/v1/users/token";

    public static final String REPORTING = "/api/v1/reports/{eventId}/details/{showingId}";

    public static final String TICKET_STATUS = "/api/v1/tickets/status";
    public static final String ORDER_STATUS = "/api/v1/orders/status";
}
