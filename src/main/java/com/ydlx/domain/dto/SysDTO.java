package com.ydlx.domain.dto;

/**
 * Created by ydlx on 2017/8/12.
 */
public class SysDTO extends BaseDTO{

    /**系统ID*/
    private String sysId;

    /**系统编码*/
    private String sysCode;

    /**系统名*/
    private String sysName;

    /**系统描述*/
    private String sysDesc;

    /**1 正常  0禁用*/
    private Integer enable;

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

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

    public String getSysDesc() {
        return sysDesc;
    }

    public void setSysDesc(String sysDesc) {
        this.sysDesc = sysDesc;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "SysDTO{" +
                "sysId='" + sysId + '\'' +
                ", sysCode='" + sysCode + '\'' +
                ", sysName='" + sysName + '\'' +
                ", sysDesc='" + sysDesc + '\'' +
                ", enable=" + enable +
                "} " + super.toString();
    }
}
