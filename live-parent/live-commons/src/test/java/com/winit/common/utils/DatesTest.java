package com.winit.common.utils;

import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Liuye on 2014/9/4.
 */
public class DatesTest {
    DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Test
    public void testGetUTCDate1(){
        Calendar calendar = Calendar.getInstance();
        //获取时间偏移量
        int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
        int dstOffset = calendar.get(Calendar.DST_OFFSET);
        Date localDate=new Date();
        Date utcDate=Dates.getUTCDate();
        Assert.assertNotNull(utcDate);
        Assert.assertTrue(localDate.getTime()-(zoneOffset+dstOffset)==utcDate.getTime());
    }

    @Test
    public void testGetUTCDate2(){
        Calendar calendar = Calendar.getInstance();
        //获取时间偏移量
        int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
        int dstOffset = calendar.get(Calendar.DST_OFFSET);
        Date localDate=new Date();
        Date utcDate=Dates.getUTCDate(localDate);
        Assert.assertTrue(localDate.getTime()-(zoneOffset+dstOffset)==utcDate.getTime());
    }

    @Test
    public void testGetLocalDate(){
        String localDate1=df.format(new Date());
        Date utcDate=Dates.getUTCDate();
        String localDate2=df.format(Dates.getLocalDate(utcDate));
        Assert.assertEquals(localDate1,localDate2);
    }
    @Test
    public void testToUTCDate(){
    	  Calendar calendar = Calendar.getInstance();
          //获取时间偏移量
          int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
          int dstOffset = calendar.get(Calendar.DST_OFFSET);
          Date date=new Date();
          long localTime=date.getTime();
          Dates.toUTCDate(date);
          long utcTime=date.getTime();
          
          Assert.assertTrue(localTime-(zoneOffset+dstOffset)==utcTime);
    }

    @Test
    public void testToLocalDate(){
    	  Calendar calendar = Calendar.getInstance();
          //获取时间偏移量
          int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
          int dstOffset = calendar.get(Calendar.DST_OFFSET);
          Date date=new Date();
          long utcTime=date.getTime();
          Dates.toLocalDate(date);
          long localTime=date.getTime();
          
          Assert.assertTrue(localTime-(zoneOffset+dstOffset)==utcTime);
    } 
    @Test
    public void formatDate(){
        String dataStr="2014-01-31";

        Assert.assertEquals(dataStr, Dates.formatDate(new Date(114, 0, 31), "yyyy-MM-dd"));
    }

    @Test
    public void parseDate(){
        String dataStr="2014-01-31";
        Assert.assertEquals(new Date(114,0,31),Dates.parseDate(dataStr,new SimpleDateFormat("yyyy-MM-dd")));
    }

    @Test
    public void parseDate2(){
        String dataStr="2014-01-31";
        Assert.assertEquals(new Date(114,0,31),Dates.parseDate(dataStr,"yyyy-MM-dd"));
    }


}
