package com.ydlx.domain.vo.request.sys;

import com.ydlx.domain.vo.PageRequestVO;

/**
 * Created by ydlx on 2017/8/14.
 */
public class QuerySysRequest extends PageRequestVO{

    /**code*/
    private String sysCode;

    /**系统名*/
    private String sysName;

    /**1 正常  0 禁用*/
    private Integer enable;

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "QuerySysRequest{" +
                "sysCode='" + sysCode + '\'' +
                ", sysName='" + sysName + '\'' +
                ", enable=" + enable +
                '}';
    }
}
