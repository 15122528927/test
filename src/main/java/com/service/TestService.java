package com.service;


import com.utils.aop.AopSemaphore;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestService {


    @AopSemaphore
    public  String  test(int i){
        try{
            //请求一个信号
            //System.out.println(Thread.currentThread().getName()+"进来了");
            Thread.sleep(1000);
            //System.out.println(Thread.currentThread().getName()+"走了");
            //释放一个信号
        }catch (Exception e){
            e.printStackTrace();
        }
        return "正常运行";
    }


    @Cacheable(cacheNames = {"cacheName"})
    public  String  Cacheable(int i){

        System.out.println("------------------------------------");
        return "正常运行";
    }


    @CacheEvict()
    public  String  CacheEvict(int i){

        System.out.println("------------------------------------");
        return "正常运行";
    }


}
