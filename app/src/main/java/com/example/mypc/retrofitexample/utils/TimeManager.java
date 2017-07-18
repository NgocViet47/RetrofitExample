package com.example.mypc.retrofitexample.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import info.vividcode.time.iso8601.Iso8601ExtendedOffsetDateTimeFormat;

/**
 * Created by MyPC on 6/14/2017.
 */

public class TimeManager {
    public static Long getTimeLocalMiliSecond() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeInMillis();
    }

    public static Long getMilliSecondTimeString(String timeInput) {
        long timeInMilliseconds = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss");
        try {
            Date mDate = simpleDateFormat.parse(timeInput);
            timeInMilliseconds = mDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeInMilliseconds;
    }
    public static Calendar getCalendar(String timeInput){
        Date mDate = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        try {
            mDate = simpleDateFormat.parse(timeInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDate);
        return calendar;
    }

    public static Calendar getCalendarByZ(String timeInput){
        Date mDate = null;
        DateFormat f = new Iso8601ExtendedOffsetDateTimeFormat();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'");
        try {
            mDate = df.parse(timeInput);
        } catch (ParseException e) {
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDate);
        return calendar;
    }
    public static String getNameDateFromCalendar(String timeInput){
        int date = getCalendar(timeInput).get(Calendar.DAY_OF_WEEK)-1;
        String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        return days[date];
    }
    public static String getNameDateBy8601(String timeInput){
        int date = getCalendarByZ(timeInput).get(Calendar.DAY_OF_WEEK)-1;
        String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        return days[date];
    }
    public static String getTimeByhhmmaa(String timeInput){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm aa");
        return simpleDateFormat.format(getCalendar(timeInput).getTime());
    }
    public static String getTimeByhhmmssByISO8601(String timeInput){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        return simpleDateFormat.format(getCalendarByZ(timeInput).getTime());
    }
    public static String getDayMothYear(String timeInput){
        String stringTime = getCalendar(timeInput).get(Calendar.DATE)
                +" "+ getCalendar(timeInput).getDisplayName(Calendar.MONTH,Calendar.LONG, Locale.ENGLISH)
                +", "+ getCalendar(timeInput).get(Calendar.YEAR);
        return stringTime;
    }
    public static String getDayMothYearByCalendar(Calendar timeInput){
        String strigTime =timeInput.get(Calendar.DATE)
                +" "+ timeInput.getDisplayName(Calendar.MONTH,Calendar.LONG, Locale.ENGLISH)
                +" "+ timeInput.get(Calendar.YEAR);
        return strigTime;
    }
    public static String getLastSyncTimeByISO8601(String timeInput){
        return getNameDateBy8601(timeInput)
                +", "+getDayMothYearByCalendar(getCalendarByZ(timeInput))
                +", "+ getTimeByhhmmssByISO8601(timeInput);
    }
    public static String getLastSyncTimeCalendarGetInstance(Calendar calendar){
        int date = calendar.get(Calendar.DAY_OF_WEEK)-1;
        String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss aa");

        return days[date]+", "+ getDayMothYearByCalendar(calendar)+", "+simpleDateFormat.format(calendar.getTime());
    }
    public static String getStringTimeIso8601ByCalendar(Calendar calendar){
        Date date = calendar.getTime();
        String formatted = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'").format(date);
        return formatted;
    }

}
