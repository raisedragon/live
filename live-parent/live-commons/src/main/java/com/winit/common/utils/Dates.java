package com.winit.common.utils;

import com.alibaba.dubbo.rpc.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URI;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Dates {

    /**
     * 获取UTC时间
     * @return UTC时间
     */
    public static Date getUTCDate(){
        return getUTCDate(new Date());
    }


    /**
     * 根据本地时间获取UTC时间
     * @param localDate
     * @return
     */
    public static Date getUTCDate(Date localDate){
        if(localDate==null){
            return null;
        }
        Calendar calendar =Calendar.getInstance();
        //获取时间偏移量
        int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
        //获取夏令时差
        int dstOffset = calendar.get(Calendar.DST_OFFSET);
        //从本地时间里扣除时间偏移量与夏令时差，即可以取得UTC时间：
        return new Date(localDate.getTime()-(zoneOffset + dstOffset));
    }
    /**
     * 根据UTC时间获取本地时间
     * @param utcDate UTC时间
     * @return 本地时间
     */
    public static Date getLocalDate(Date utcDate){
        if(utcDate==null){
            return null;
        }
        Calendar calendar =Calendar.getInstance();
        //获取时间偏移量
        int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
        //获取夏令时差
        int dstOffset = calendar.get(Calendar.DST_OFFSET);
        //根据utc时间里增加时间偏移量与夏令时差，即可以取得本地时间：
        return new Date(utcDate.getTime()+(zoneOffset + dstOffset));
    }
    
    public static void toUTCDate(Date localDate){
        if(localDate==null){
            return;
        }
        Calendar calendar =Calendar.getInstance();
        //获取时间偏移量
        int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
        //获取夏令时差
        int dstOffset = calendar.get(Calendar.DST_OFFSET);
        //从本地时间里扣除时间偏移量与夏令时差，即可以取得UTC时间：
        localDate.setTime(localDate.getTime()-(zoneOffset + dstOffset));    	
    }
    
    public static void toLocalDate(Date utcDate){
        if(utcDate==null){
            return;
        }
        Calendar calendar =Calendar.getInstance();
        //获取时间偏移量
        int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
        //获取夏令时差
        int dstOffset = calendar.get(Calendar.DST_OFFSET);
        //根据utc时间里增加时间偏移量与夏令时差，即可以取得本地时间：
        utcDate.setTime(utcDate.getTime()+(zoneOffset + dstOffset));
    }
    

    /**
     * 格式化日期
     * @param date 日期
     * @param format 格式
     * @return
     */
    public static String formatDate(Date date, String format) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 解析字体串为日期
     * @param date 日期字符串
     * @param df    格式化对象
     * @return
     */
    public static Date parseDate(String date, DateFormat df) {
        if (date == null) {
            return null;
        }
        try {
            return df.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解析字体串为日期
     * @param date 日期字符串
     * @param format    日期格式化
     * @return
     */
    public static Date parseDate(String date, String format) {
        if (date == null) {
            return null;
        }
        return parseDate(date,new SimpleDateFormat(format));
    }
}
