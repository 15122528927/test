package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.Student;
import com.entity.SysTagConf;
import com.utils.treeUtil.ParentBuildCommon;
import com.utils.treeUtil.TreeUtilCommon;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * java 父子结构的数据 转换成 树型结构的数据
 * */
@RestController
@RequestMapping("/tree")
public class TreeController {


    @GetMapping(value = "/demo")
    public JSONObject demo2() throws Exception {

        List<SysTagConf> sysTagConfList = new ArrayList<SysTagConf>();
        for(int i = 0; i < 10 ;i++){
            SysTagConf sysTagConf = new SysTagConf();
            if(i == 0){
                sysTagConf.setRowGuid(i+"");
                sysTagConf.setParentGuid("");

            }else {
                sysTagConf.setRowGuid((i)+"");
                sysTagConf.setParentGuid((i-1)+"");
            }
            sysTagConfList.add(sysTagConf);
        }

        //转化成 树形结构数据
        sysTagConfList = TreeUtilCommon.buildTree(sysTagConfList, "com.entity.SysTagConf", "rowGuid", "parentGuid", "childList");

        JSONObject  JSONObject = new JSONObject();
        JSONObject.put("result", sysTagConfList);
        System.out.println(JSONObject);
        return JSONObject;
    }

    /**
     * 根据子集节点 构建父级 数据
     * @param examineUser
     * @param ids
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/screenNodes")
    public JSONObject screenNodes(@RequestBody Student examineUser ,@RequestParam String[] ids) throws Exception {

        List<SysTagConf> nodes = new ArrayList<SysTagConf>();

        List<SysTagConf> sysTagConfList = new ArrayList<SysTagConf>();
        for(int i = 0; i < 10 ;i++){
            SysTagConf sysTagConf = new SysTagConf();
            if(i == 0){
                sysTagConf.setRowGuid(i+"");
                sysTagConf.setParentGuid("");

            }else {
                sysTagConf.setRowGuid((i)+"");
                sysTagConf.setParentGuid((i-1)+"");
            }

            if(i == 3){
                nodes.add(sysTagConf);
            }
            sysTagConfList.add(sysTagConf);
        }

        //筛选父级 节点
        List<SysTagConf> nodes_new = ParentBuildCommon.screenNodes( nodes , sysTagConfList, "com.entity.SysTagConf", "rowGuid", "parentGuid");

        //转化成 树形结构数据
        List<SysTagConf>  nodes_new_new = TreeUtilCommon.buildTree(nodes_new, "com.entity.SysTagConf", "rowGuid", "parentGuid", "childList");

        JSONObject  JSONObject = new JSONObject();
        JSONObject.put("examineUser" , nodes_new_new);
        JSONObject.put("ids", ids);
        return JSONObject;
    }
}
