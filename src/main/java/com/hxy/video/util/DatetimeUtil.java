package com.hxy.video.util;

import org.apache.commons.lang.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期、时间统一处理
 * <p>
 * Created by hxy on 2021/9/7
 */
public class DatetimeUtil {
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        TimeZone timeZone = TimeZone.getDefault();
        return DateFormatUtils.format(date, pattern, timeZone);
    }

    /**
     * 计算两天之间的天数
     *
     * @param startStr 开始时间
     * @param endStr   结束时间
     * @return 相差天数
     */
    public static int daysBetween(String startStr, String endStr) {
        int daysBetween = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse(startStr);
            Calendar startDate = Calendar.getInstance();
            startDate.setTime(date1);

            Date date2 = sdf.parse(endStr);
            Calendar endDate = Calendar.getInstance();
            endDate.setTime(date2);
            Calendar date = (Calendar) startDate.clone();

            while (date.before(endDate)) {
                date.add(Calendar.DAY_OF_MONTH, 1);
                daysBetween++;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return daysBetween;
    }

    public static void main(String[] args) {
        int days = daysBetween("2023-04-25", "2023-05-02");
        System.out.println(days);
    }
}
