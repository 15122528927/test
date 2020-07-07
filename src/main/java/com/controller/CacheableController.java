package com.controller;


import com.service.TestService;
import com.utils.aop.AopSemaphore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cacheable")
public class CacheableController {

    @Autowired
    private TestService testService;


    /**
     * 缓存 处理
     */
    @PostMapping("cacheable")
    public String fileUpload2() throws Exception {
        return testService.Cacheable(1);
    }

}
