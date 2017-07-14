package com.sein.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ldb on 2017/3/29.
 * 日期工具类
 */
public class DateUtil {

    /**
     * 获取与当前时间的分钟差
     * @param dateStart
     * @return
     */
    public static long  getMinDifference(String dateStart){
        long result = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date d1 = format.parse(dateStart);
            Date d2 = new Date();
            //毫秒ms
            long diff = d2.getTime() - d1.getTime();
            result=diff/60000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 将字符串类型的日期转化格式
     * @param date
     * @param type
     * @return
     */
    public static String formatStrToStr(String date,String type){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result="";
        try {
            Date d=format.parse(date);
            result=DateUtil.formatDateToStr(d,type);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 获取当前时间的字符串
     * @return
     */
    public static String getCurrentDateStr(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    /**
     * 将日期类型转化成字符串
     * @param date
     * @param type
     * @return
     */
    public static String formatDateToStr(Date date,String type){
        SimpleDateFormat format = new SimpleDateFormat(type);
        return format.format(date);
    }

    /**
     * 将字符串转化成日期类型
     * @param date
     * @param type
     * @return
     * @throws Exception
     */
    public static Date formatStrToDate(String date,String type){
        SimpleDateFormat format = new SimpleDateFormat(type);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
