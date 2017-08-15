package com.ydlx.domain.vo.request.pri;

import java.io.Serializable;

/**
 * Created by ydlx on 2017/8/15.
 */
public class UpdatePriRequest implements Serializable{

    /**权限ID*/
    private String priId;

    /**权限名称*/
    private String priName;

    /**权限描述*/
    private String priDesc;

    public String getPriId() {
        return priId;
    }

    public void setPriId(String priId) {
        this.priId = priId;
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
