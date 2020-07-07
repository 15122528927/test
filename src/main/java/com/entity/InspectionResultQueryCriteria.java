package com.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author gxzn
 * @date 2020-05-15
 */
@Data
public class InspectionResultQueryCriteria {

    private Long id; //主键id

    /** 检验检测 */
    private Long inspectionId;

    private String type;


    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date uploadTime;
}
