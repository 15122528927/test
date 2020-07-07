package com.controller;


import com.service.TestService;
import com.utils.aop.AopSemaphore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopController {

    @Autowired
    private TestService testService;


    /**
     * aop 面向切面编程
     */
    @AopSemaphore
    @PostMapping("test")
    public String fileUpload2() throws Exception {

        return"test";
    }

    /**
     * aop 面向切面编程
     */
    @PostMapping("aopSemaphore")
    public void AopSemaphore() throws Exception {
        //执行 100 线程
        for (int i = 0; i < 100; i++) {
             int userId = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    testService.test(userId);
                    System.out.println("返回的结果" +testService.test(userId) );
                }
            }).start();
        }
    }




}
