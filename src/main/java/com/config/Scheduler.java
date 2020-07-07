package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时器
 */
@Component
public class Scheduler {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //每隔2秒执行一次
    //@Scheduled(fixedRate = 2000)
    public void testTasks() {
        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
    }

    //每天3：05执行
    @Scheduled(cron = "0 05 03 ? * *")
    public void testTasks2() {
        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
    }

    /**
     * 启动项目的时候 执行的方法
     */
    @PostConstruct
    public void timer() throws Exception {

        //获取项目的路径 并把二维码存储起来
        String path =  System.getProperty("user.dir");

        System.out.println("---------------------------- 启动项目执行的方法"  + path);
    }


    //定时器时间配置
    @Scheduled(cron = "${scheduledStr}")
    public void test2() {
        System.out.println("定时任务执行时间————————————————————————————————————————————————————————：" + dateFormat.format(new Date()));
    }
}
