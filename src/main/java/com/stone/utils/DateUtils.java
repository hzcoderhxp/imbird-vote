package com.stone.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by chenghao on 4/5/16.
 */
public class DateUtils {


    private static final String FORMAT_DATETIME_LONG = "yyyyMMddHHmmss";
    private static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    private static final String FORMAT_DATEMONTH = "yyyy-MM";
    private static final String FORMAT_DATE = "yyyy-MM-dd";
    private static final String FORMAT_TIME = "HH:mm:ss";
    private static final String FORMAT_TIME_HOUR_MIN = "HH:mm";
    private static final String FORMAT_TIME_HHMMSS = "HHmmss";
    private static final String FORMAT_DATETIME_YYYYMMDD = "yyyyMMdd";
    private static final String FORMAT_DATETIME_4MIN = "yyyyMMddHHmm";
    private static final String FORMAT_DATETIME_YYMMDD="yyMMdd";
    private static org.slf4j.Logger logger= org.slf4j.LoggerFactory.getLogger(DateUtils.class);
    public static final SimpleDateFormat sdf=new SimpleDateFormat();
    public static String formatDate(Date date,String format){
        sdf.applyPattern(format);
        return sdf.format(date);
    }

    public static String formatDate(Date date){
        return formatDate(date, FORMAT_DATE);
    }

    public static String formatDateTime(Date date){
        return formatDate(date, FORMAT_DATETIME);
    }

    public static Date parseDate(String strDate) {
        return parse(strDate, FORMAT_DATE);
    }

    public static Date parseDateTime(String strDate) {
        return parse(strDate, FORMAT_DATETIME);
    }

    /**
     * 将日期转换为指定格式字符串
     *
     * @param date
     * @param strFormat
     * @return
     */
    public final static String format(Date date, String strFormat) {
        return new SimpleDateFormat(strFormat).format(date);
    }

    /**
     * 将日期转化为yyyy-MM格式字符串
     *
     * @param date
     * @return
     */
    public final static String formatDateMonth(Date date) {
        return format(date, FORMAT_DATEMONTH);
    }

    public static Date parseDateMonth(String strDate) {
        return parse(strDate, FORMAT_DATEMONTH);
    }

    public static Date getMonthFirstDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));

        // 设置时间为0时
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getMonthLastDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

        // 设置时间为最后时刻
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    public static Date beforeXMonth(Date date, Integer X) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, X);
        return cal.getTime();
    }

    public static Date getCleanDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        date = cal.getTime();
        return date;
    }

    public static Date parse(String strDate, String strFormat) {

        if (strDate == null || strDate.trim().length() == 0) {
            return null;
        }

        try {
            return new SimpleDateFormat(strFormat).parse(strDate);
        } catch (ParseException e) {
            logger.error(e.getMessage(),e);
        }

        return null;
    }
    public static Date beforeXDay(Date date, Integer X) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, X);

        // 设置时间为0时
        getDayFirstTime(cal);
        return cal.getTime();
    }

    public static Date addDay(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
    public static Date addHour(Date date, int hours){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hours);
        return cal.getTime();
    }

    public static Date getDayFirstTime(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return getDayFirstTime(cal).getTime();
    }

    public static Calendar getDayFirstTime(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }
    public static Date getDayFinalTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return getDayFinalTime(cal).getTime();
    }
    public static Calendar getDayFinalTime(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal;
    }

    public static int getDiffDay(Date startDate, Date endDate) {
        int days = (int) ((getDayFirstTime(endDate).getTime() - getDayFirstTime(startDate).getTime()) / (1000l*3600l*24l));
        return days;
    }

    public static int getDaysBetweenToDate(Date end, Date start) {
        Calendar calst = Calendar.getInstance();
        Calendar caled = Calendar.getInstance();

        calst.setTime(start);
        caled.setTime(end);
        // 设置时间为0时
        calst.set(Calendar.HOUR_OF_DAY, 0);
        calst.set(Calendar.MINUTE, 0);
        calst.set(Calendar.SECOND, 0);
        caled.set(Calendar.HOUR_OF_DAY, 0);
        caled.set(Calendar.MINUTE, 0);
        caled.set(Calendar.SECOND, 0);
        // 得到两个日期相差的天数
        int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;
        return days;
    }

    public static Date addYear(Date date, int years) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        return cal.getTime();
    }
}
