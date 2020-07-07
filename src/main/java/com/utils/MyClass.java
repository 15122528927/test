package com.utils;


import com.utils.aop.AopSemaphore;
import com.utils.aop.AopTest;
import com.utils.request.HttpRequestUtil;

import java.util.concurrent.Semaphore;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 线程控制 限制线程数量
 */
public class MyClass {

    static Semaphore semaphore = new Semaphore(5, true);

    public static void main(String[] args) {

        for (int i = 0; i < 200; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpRequestUtil.doGet("http://localhost:8080/profile/2020/04/06/work.zip", "");
                }
            }).start();
        }
    }

    @AopSemaphore
    @AopTest
    public static void test() {
        try {
            //请求一个信号
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "进来了");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "走了");
            //释放一个信号
            semaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
