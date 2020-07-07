package com.controller;


import com.alibaba.fastjson.JSONObject;
import com.entity.InspectionResultQueryCriteria;
import com.entity.Student;
import com.utils.MyExecutor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/json")
public class JsonController {


    /**
     * 接收不确定json 数据
     * @param jsonObject
     * @return
     */
    @PostMapping("/json")
    public JSONObject json(@RequestBody JSONObject jsonObject) {
        JSONObject JSONObject = new JSONObject();
        List<Map> objs = (List<Map>)jsonObject.get("objs");

        for(int i = 0;i< objs.size();i++){
            JSONObject.put(i+"", objs.get(i).get("name"));
        }
        return JSONObject;
    }


    /**
     * 接收不确定json 数据
     * @param student
     * @return
     */
    @PostMapping("/entity")
    public Student json(@Validated @RequestBody Student student) throws Exception {

/*        MyExecutor myExecutor = new MyExecutor();
        myExecutor.fun();*/


        return student;
    }


    /**
     * 接收不确定json 数据
     * @return
     */
    @PostMapping("/strs")
    public JSONObject strs(@RequestBody String[]  strs  ) {


        JSONObject json = new JSONObject();
        json.put("strs" , strs);
        return json;
    }


    /**
     * 接收不确定json 数据
     * @return
     */
    @GetMapping("/date")
    public JSONObject strs(InspectionResultQueryCriteria criteria) {


        JSONObject json = new JSONObject();
        json.put("date" , criteria);
        return json;
    }

}
