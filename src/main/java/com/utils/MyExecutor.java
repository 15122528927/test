package com.utils;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建的线程
 **/

@Component
public class MyExecutor {

    private ExecutorService executor = Executors.newCachedThreadPool() ;

    public  void fun() throws Exception {
        executor.submit(new Runnable(){
            public void run() {
                try {
                    //要执行的业务代码，我们这里没有写方法，可以让线程休息几秒进行测试
                    Thread.sleep(10000);
                    System.out.print("睡够啦~");
                }catch(Exception e) {
                    throw new RuntimeException("报错啦！！");
                }

            }
        });

        executor.submit(new Runnable(){
            public void run() {
                try {
                    //要执行的业务代码，我们这里没有写方法，可以让线程休息几秒进行测试
                    Thread.sleep(10000);
                    System.out.print("睡够啦~21");
                }catch(Exception e) {
                    throw new RuntimeException("报错啦！！");
                }

            }
        });


    }
}
