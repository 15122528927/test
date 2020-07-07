package com.utils.time;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 得到指定日期内每天的开始时间和结束时间
 * @author wjq
 */
public class StartTimeToEndTime {


    public static void startTimeToEndTime(Date date) throws ParseException {


        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 1);

        String date_str = c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DATE) ;

        String  date_str1 = date_str + " 00:00:00";
        String  date_str2 = date_str + " 23:59:59";

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = fmt.parse(date_str1);
        Date parse2 = fmt.parse(date_str1);




    }
}
