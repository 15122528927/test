package com.utils.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.Semaphore;

@Component
@Aspect
public class SemaphoreAspect {

    static Semaphore semaphore = new Semaphore(5,true);
    static int number = 0;

    @Pointcut("@annotation(com.utils.aop.AopSemaphore)")
    public void addAdvice() {
    }

    @Around("addAdvice()")
    public Object Interceptor(ProceedingJoinPoint pjp) throws InterruptedException {

        if(number  > 15){
            return "超出等待人数";
        }else{
            number = number +1 ;
        }

        Object[] args = pjp.getArgs();
       // System.out.print("进入aop Semaphore 线程锁 " + args[0] +"\n");
        semaphore.acquire();
        Object obj = null;

        try {
            obj = pjp.proceed();  //执行区域线程 并返回执行结果
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally{
            semaphore.release();
            number = number - 1 ;
            return "进入aop";
        }
    }
}
