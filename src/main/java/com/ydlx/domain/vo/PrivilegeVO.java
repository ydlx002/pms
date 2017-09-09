package com.ydlx.domain.vo;

/**
 * Created by ydlx on 2017/8/14.
 */
public class PrivilegeVO extends BaseVO{

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

    /**权限类型 0菜单 1元素 2文件*/
    private Integer priType;

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

    public Integer getPriType() {
        return priType;
    }

    public void setPriType(Integer priType) {
        this.priType = priType;
    }

    @Override
    public String toString() {
        return "PrivilegeVO{" +
                "priId='" + priId + '\'' +
                ", sysId='" + sysId + '\'' +
                ", priCode='" + priCode + '\'' +
                ", priName='" + priName + '\'' +
                ", priDesc='" + priDesc + '\'' +
                "} " + super.toString();
    }
}
