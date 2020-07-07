package com.utils.aop;


import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AopSemaphore {

    String description() default "";
}
