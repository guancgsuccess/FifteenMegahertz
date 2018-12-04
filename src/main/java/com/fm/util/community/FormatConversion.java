package com.fm.util.community;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换工具类
 * YftPaper
 */
public class FormatConversion {

    public static final String PATTERN_ONE = "yyyy-MM-dd";
    public static final String PATTERN_TWO = "yyyy-MM-dd HH:mm:ss";

    /**
     * java时间转字符串时间
     *
     * @param date    java时间
     * @param pattern 格式
     * @return 字符串时间
     */
    public static String dateToString(Date date, String pattern) {

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 字符串时间转java时间
     *
     * @param date    字符串时间
     * @param pattern 格式
     * @return java时间
     * @throws ParseException 字符串格式不符异常
     */
    public static Date stringToDate(String date, String pattern) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(date);
    }
}
