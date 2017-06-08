package com.example.mypc.retrofitexample.sharedpreference;


import java.util.Calendar;

/**
 * Created by MyPC on 6/6/2017.
 */

public class GetTimeToMilliSecond {
    public static Long getTimeLocal(){
        Calendar calendar = Calendar.getInstance() ;
        return calendar.getTimeInMillis();
    }
}
