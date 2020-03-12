package com.demo2.study3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public DateUtils() {
    }

    public static String dateToString(Date date, String format){
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        String s = sdf.format(date);
        return s;
    }
    public static Date stringToDate(String s,String format) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        Date date = sdf.parse(s);
        return date;
    }
}
