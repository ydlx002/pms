package com.ydlx.domain.vo.request.pri;

import java.io.Serializable;

/**
 * Created by ydlx on 2017/8/15.
 */
public class AddPriRequest implements Serializable{

    /**权限代码*/
    private String priCode;

    /**权限名称*/
    private String priName;

    /**权限名称*/
    private String priDesc;

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
}
