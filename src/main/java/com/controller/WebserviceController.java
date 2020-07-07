package com.controller;


import com.alibaba.fastjson.JSONObject;
import com.utils.webservice.demo.Go;
import com.utils.webservice.demo.HBJSmsCenter;
import com.utils.webservice.demo.HBJSmsCenterPortType;
import jdk.nashorn.internal.runtime.options.Options;
import org.apache.axis.AxisFault;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/webservice")
public class WebserviceController {


    private HBJSmsCenterPortType hBJSmsCenterPortType;

    /**
     * 接收不确定json 数据
     *
     * @return
     */
    @PostMapping("/test")
    public String strs() {

        try {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSSSSS");
            URL url = new URL("http://10.12.100.133:8080/hbj_sms_ws/services/HBJ_smsCenter?wsdl");
            HBJSmsCenter ss = new HBJSmsCenter(url);
            HBJSmsCenterPortType service = ss.getHBJSmsCenterHttpSoap11Endpoint();
            String result = service.go("15122528927"
                    , "测试短信接口 是否可以实现"
                    , "jdcc"
                    , "DHZ" + simpleDateFormat.format(new Date())
                    , "https://www.baidu.com/"
                    , "hbjmail"
                    , "dhz");

            return result;
        } catch (
                Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
            return "异常";
        }
    }


    public  void   test(){

    }



}
