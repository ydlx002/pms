package com.ydlx.domain.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ydlx on 2017/6/22.
 */
public class BaseDTO implements Serializable{

    /**操作员*/
    private String operator;

    /**操作员ID*/
    private String operatorId;

    /**创建时间*/
    private Date createTime;

    /**更新时间*/
    private Date updateTime;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BaseDTO{" +
                "operator='" + operator + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public BaseDTO(){
        createTime = new Date();
        updateTime = new Date();
    }
}
