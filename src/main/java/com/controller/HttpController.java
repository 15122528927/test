package com.controller;


import com.alibaba.fastjson.JSONObject;
import com.utils.request.HttpRequestUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/http")
public class HttpController {


    /**
     * 获取请求ip地址
     * */
    @GetMapping("/message_post")
    public String message_post(HttpServletRequest request) {
        JSONObject jsonStr = new JSONObject();

        String url = "http://10.12.100.133:8080/hbj_sms_ws/services/HBJ_smsCenter?wsdl";


        jsonStr.put("phone","15122528927");
        jsonStr.put("content","测试");
        jsonStr.put("officeNO","keji");
        jsonStr.put("wsurl","http://192.168.3.64:8080");
        jsonStr.put("method","sendMessage");
        jsonStr.put("system","卡卡");

        //调用 发送短信接口

        return  HttpRequestUtil.doPost(url, null , jsonStr.toString());

    }

    /**
     * 获取请求ip地址
     * */
    @GetMapping("/message_get")
    public String message_get(HttpServletRequest request) {
        JSONObject jsonStr = new JSONObject();

        String url = "http://10.12.100.133:8080/hbj_sms_ws/services/HBJ_smsCenter?wsdl?" +
                "phone=15122528927&content=测试&officeNO=hbj&wsurl=http://192.168.3.64:8080" +
                "&method=sendMessage&system=largesupervise";

        jsonStr.put("phone","15122528927");
        jsonStr.put("content","测试");
        jsonStr.put("officeNO","hbj");
        jsonStr.put("wsurl","http://192.168.3.64:8080");
        jsonStr.put("method","sendMessage");
        jsonStr.put("system","largesupervise");

        //调用 发送短信接口

        return  HttpRequestUtil.doGet(url, null );

    }







}
