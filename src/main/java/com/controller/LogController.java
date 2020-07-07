package com.controller;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/log")
@Slf4j //操作日志注解
public class LogController {

    /**
     * 日志 操作类
     * */
    @GetMapping("/test")
    public JSONObject test(HttpServletRequest request) {
        JSONObject json = new JSONObject();
        log.info("请求一次controller", request.getMethod());
        json.put("massage", "访问一遍cntroller");
        return json;
    }
}
