package com.fm.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 该类表示日期相关的操作
 */
public class DateUtil {
/*    public static final String YMDHMS_PATTERN = "yyyy/MM/dd HH:mm:ss";
    public static final String YMD_PATTERN = "yyyy/MM/dd";
    public static final String HMS_PATTERN = "HH:mm:ss";*/

    /**
     * 日期转换成字符串
     * @param date 需要格式化的日期对象
     * @param pattern   日期的格式
     * @return  返回字符串表示的日期
     */
    public static String date2String(Date date, String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        return  df.format(date);
    }

    /**
     * 字符串转换成日期对象
     * @param strDate   字符串表示的日期
     * @param pattern    日期的格式
     * @return  返回对应的日期对象
     */
    public static Date string2Date(String strDate,String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
