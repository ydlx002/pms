package com.ydlx.domain.vo.request.user;

import java.io.Serializable;

/**
 * Created by ydlx on 2017/8/14.
 */
public class UpdateUserRequest implements Serializable{

    /**用户姓名*/
    private String fullName;

    /**电子邮箱*/
    private String email;

    /**手机号码*/
    private String mobile;

    /**昵称*/
    private String nickName;

    /**备注*/
    private String remark;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
