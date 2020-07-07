package com.utils.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

    @Pointcut("@annotation(com.utils.aop.AopTest)")
    public void addAdvice() {
    }

    @Around("addAdvice()")
    public Object Interceptor(ProceedingJoinPoint pjp) {
        System.out.print("进入aop");
        Object result = null;
        Object[] args = pjp.getArgs();
//		if (args != null && args.length > 0) {
//			String param = (String) args[0];
//			if (null == param || param.trim() == "") {
//				return "no parameter";
//			}
//		}
        try {
            result = pjp.proceed(); //执行线程
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }
}
