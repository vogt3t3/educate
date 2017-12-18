package com.education.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 日期类转换
 *
 */
public class DateUtil {
    /**Date类型转换为String类型
     * @param date 日期
     * @param format 时间转换格式
     * @return String
     */
    public static String formatDate(Date date,String format){
        String result="";
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        if(date!=null){
            result=sdf.format(date);
        }
        return result;
    }
    /**
     * @param str 时间字符串
     * @param format 时间转换格式
     * @return Date
     * @throws ParseException 日期转换异常
     */
    public static Date formatString (String str,String format) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        return sdf.parse(str);
    }
}
