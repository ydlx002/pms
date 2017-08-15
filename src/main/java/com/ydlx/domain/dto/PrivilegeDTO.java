package com.ydlx.domain.dto;

/**
 * Created by ydlx on 2017/8/14.
 */
public class PrivilegeDTO extends BaseDTO{

    /**权限ID*/
    private String priId;

    /**系统ID*/
    private String sysId;

    /**权限代码*/
    private String priCode;

    /**权限名称*/
    private String priName;

    /**权限名称*/
    private String priDesc;

    public String getPriId() {
        return priId;
    }

    public void setPriId(String priId) {
        this.priId = priId;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getPriCode() {
        return priCode;
    }

    public void setPriCode(String priCode) {
        this.priCode = priCode;
    }

    public String getPriName() {
        return priName;
    }

    public void setPriName(String priName) {
        this.priName = priName;
    }

    public String getPriDesc() {
        return priDesc;
    }

    public void setPriDesc(String priDesc) {
        this.priDesc = priDesc;
    }

    @Override
    public String toString() {
        return "PrivilegeDTO{" +
                "priId='" + priId + '\'' +
                ", sysId='" + sysId + '\'' +
                ", priCode='" + priCode + '\'' +
                ", priName='" + priName + '\'' +
                ", priDesc='" + priDesc + '\'' +
                "} " + super.toString();
    }
}
