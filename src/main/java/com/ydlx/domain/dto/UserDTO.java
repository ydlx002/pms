package com.ydlx.domain.dto;

/**
 * 用户信息
 * Created by ydlx on 2017/6/22.
 */
public class UserDTO extends BaseDTO{

    /**用户ID*/
    private String userId;

    /**系统账号*/
    private String loginAccount;

    /**用户姓名*/
    private String fullName;

    /**用户昵称*/
    private String nickName;

    /**用户邮箱*/
    private String email;

    /**联系电话*/
    private String mobile;

    /**备注*/
    private String remark;

    /**状态*/
    private Integer state;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UserDTO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public UserDTO setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                ", userId='" + userId + '\'' +
                ", loginAccount='" + loginAccount + '\'' +
                ", fullName='" + fullName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", remark='" + remark + '\'' +
                ", state=" + state +
                "} " + super.toString();
    }
}
