package com.ydlx.domain.dto;

/**
 * Created by ydlx on 2017/8/14.
 */
public class PrivilegeDTO extends BaseDTO{

    /**权限ID*/
    private String priId;

    /**权限代码*/
    private String priCode;

    /**权限名称*/
    private String priName;

    /**权限名称*/
    private String priDesc;

    /**权限类型 0查询 1新增 2更新 3删除*/
    private Integer priType;

    public String getPriId() {
        return priId;
    }

    public void setPriId(String priId) {
        this.priId = priId;
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
        return "PrivilegeDTO{" +
                "priId='" + priId + '\'' +
                ", priCode='" + priCode + '\'' +
                ", priName='" + priName + '\'' +
                ", priDesc='" + priDesc + '\'' +
                ", priType=" + priType +
                '}';
    }

    public PrivilegeDTO(){

    }
    public PrivilegeDTO(String sysId){
        this.setSysId(sysId);
    }
}
