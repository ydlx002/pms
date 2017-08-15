package com.ydlx.domain.dto;

/**
 * Created by ydlx on 2017/7/28.
 */
public class SysUserDTO extends BaseDTO{

    /**系统ID*/
    private String sysId;

    /**系统名字*/
    private String sysName;

    /**用户ID*/
    private String userId;

    /**登录密码*/
    private String password;

    /**用户类型ID*/
    private String userTypeId;

    /**0 禁用 1启用*/
    private Integer state;

    public String getSysId() {
        return sysId;
    }

    public SysUserDTO setSysId(String sysId) {
        this.sysId = sysId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public SysUserDTO setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserTypeId() {
        return userTypeId;
    }

    public SysUserDTO setUserTypeId(String userTypeId) {
        this.userTypeId = userTypeId;
        return  this;
    }

    public Integer getState() {
        return state;
    }

    public SysUserDTO setState(Integer state) {
        this.state = state;
        return this;
    }

    public String getSysName() {
        return sysName;
    }

    public SysUserDTO setSysName(String sysName) {
        this.sysName = sysName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SysUserDTO{" +
                "sysId='" + sysId + '\'' +
                ", sysName='" + sysName + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", userTypeId='" + userTypeId + '\'' +
                ", state=" + state +
                "} " + super.toString();
    }
}
