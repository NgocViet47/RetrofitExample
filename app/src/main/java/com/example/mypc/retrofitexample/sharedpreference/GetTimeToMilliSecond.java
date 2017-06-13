package com.example.mypc.retrofitexample.sharedpreference;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by MyPC on 6/6/2017.
 */

public class GetTimeToMilliSecond {
    public static Long getTimeLocal() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeInMillis();
    }

    public static Long getMilliSecondTimeString(String timeInput) {
        String time = "";
        for(String cut : timeInput.split("T")){
            time += cut+" ";
        }
        long timeInMilliseconds = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss ");
        try {
            Date mDate = simpleDateFormat.parse(time);
            timeInMilliseconds = mDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeInMilliseconds;
    }
}
