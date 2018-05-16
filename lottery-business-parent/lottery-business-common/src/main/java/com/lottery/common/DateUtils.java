package com.lottery.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date d = new Date();
        String dateNowStr = sdf.format(d);
        return dateNowStr;
    }

    public static String getHour(){
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        return hour+""+minute;
    }
}
