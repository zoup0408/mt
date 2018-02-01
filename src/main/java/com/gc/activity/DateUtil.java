package com.gc.activity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String getDateStr() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    public static String getDateDay() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static String getDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }
}
