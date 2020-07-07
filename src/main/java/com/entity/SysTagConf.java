package com.entity;

import com.alibaba.fastjson.JSONObject;
import com.utils.deepCopy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SysTagConf implements Serializable {

    private String rowGuid;         //唯一标识
    private String name;            //标签名称
    private String opType;          //授权类型 0全部 1目录清单 2实施清单 3办理项
    private String useLevel;        //使用层级 0不限 2省级 3地市级 4区县级
    private float sort;            //排序
    private String parentGuid;      //父节点标识
    private String bakNote;         //备注
    private String createUId;       //创建人ID
    private String createUName;     //创建人名称
    private String createTime;      //创建时间
    private String updateUId;       //更新人ID
    private String updateUName;     //更新人名称
    private String updateTime;      //更新时间
    private String parentName;      //父节点名称
    private List<SysTagConf> childList;

    public String getRowGuid() {
        return rowGuid;
    }

    public void setRowGuid(String rowGuid) {
        this.rowGuid = rowGuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getUseLevel() {
        return useLevel;
    }

    public void setUseLevel(String useLevel) {
        this.useLevel = useLevel;
    }

    public float getSort() {
        return sort;
    }

    public void setSort(float sort) {
        this.sort = sort;
    }

    public String getParentGuid() {
        return parentGuid;
    }

    public void setParentGuid(String parentGuid) {
        this.parentGuid = parentGuid;
    }

    public String getBakNote() {
        return bakNote;
    }

    public void setBakNote(String bakNote) {
        this.bakNote = bakNote;
    }

    public String getCreateUId() {
        return createUId;
    }

    public void setCreateUId(String createUId) {
        this.createUId = createUId;
    }

    public String getCreateUName() {
        return createUName;
    }

    public void setCreateUName(String createUName) {
        this.createUName = createUName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUId() {
        return updateUId;
    }

    public void setUpdateUId(String updateUId) {
        this.updateUId = updateUId;
    }

    public String getUpdateUName() {
        return updateUName;
    }

    public void setUpdateUName(String updateUName) {
        this.updateUName = updateUName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<SysTagConf> getChildList() {
        return childList;
    }

    public void setChildList(List<SysTagConf> childList) {
        this.childList = childList;
    }


    //深度复制 demo
    public static void main(String args[]) throws Exception {

        List<SysTagConf> entitys = new  ArrayList<SysTagConf>();
        SysTagConf SysTagConf = new SysTagConf();
        SysTagConf.setName("asdads");
        entitys.add(SysTagConf);

        Object obj  = entitys;

        List<SysTagConf> destList= deepCopy.deepCopy(entitys);
        JSONObject json = new JSONObject();
        json.put("a", destList);
        System.out.print(json);



    }
}
