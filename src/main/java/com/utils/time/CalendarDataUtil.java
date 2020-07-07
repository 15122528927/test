package com.utils.time;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 操作时间的工具类
 **/
public class CalendarDataUtil {

    public static void main(String[] args) throws ParseException, java.text.ParseException {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -6);

        String before_six = c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH);
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(sdf.parse(before_six));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.setTime(sdf.parse(sdf.format(new Date())));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);

            System.out.println(max);

        }
        //  Calendar ת  timestamp
        Timestamp Timestamp = new Timestamp(max.getTimeInMillis());
//        System.out.println(result);

        //DateתTimestamp
        Timestamp createTime = new Timestamp(new Date().getTime());

        //TimestampתDate
//        Timestamp t = new Timestamp(System.currentTimeMillis());
//        Date d = new Date(t.getTime());

        //date ת  Calendar
//        Date date=new Date();
//        Calendar cal=Calendar.getInstance();
//        cal.setTime(date);
//        System.out.println(cal.get(Calendar.YEAR));

        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

    }

}
