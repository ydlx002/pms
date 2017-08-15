package com.ydlx.domain.vo.request.sys;

import java.io.Serializable;

/**
 * Created by ydlx on 2017/8/14.
 */
public class UpdateSysRequest implements Serializable{

    /**系统名称*/
    private String sysName;

    /**系统编码*/
    private String sysCode;

    /**系统描述*/
    private String sysDesc;

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getSysDesc() {
        return sysDesc;
    }

    public void setSysDesc(String sysDesc) {
        this.sysDesc = sysDesc;
    }

    @Override
    public String toString() {
        return "UpdateSysRequest{" +
                "sysName='" + sysName + '\'' +
                ", sysCode='" + sysCode + '\'' +
                ", sysDesc='" + sysDesc + '\'' +
                '}';
    }
}
