package com.tienchih.zhgl.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alarm_folw_record")
public class AlarmFolwRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String pointKey;

    private String acu;

    private String value;

    private String createDate;

    private String startTime;

    private String endTime;

    private String operator;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAcu() {
        return acu;
    }

    public void setAcu(String acu) {
        this.acu = acu;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPointKey() {
        return pointKey;
    }

    public void setPointKey(String pointKey) {
        this.pointKey = pointKey == null ? null : pointKey.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}