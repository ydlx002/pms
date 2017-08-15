package com.ydlx.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ydlx on 2017/5/30.
 */
public class BaseVO implements Serializable{

    /**操作员*/
    private String operator;

    /**更新时间*/
    private Date updateTime;

    /**创建时间*/
    private Date createTime;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BaseVO{" +
                "operator='" + operator + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                '}';
    }
}
