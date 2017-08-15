package com.ydlx.domain.vo;

/**
 * 用户信息请求实体类，主要用户向前台展示用户信息以及新增或编辑用户信息
 * Created by ydlx on 2017/5/30.
 */
public class UserVO extends BaseVO{

    /**userId*/
    private String userId;

    /**登录账号*/
    private String loginAccount;

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

    /**1 正常  0 禁用*/
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

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getEmail() {
        return email;
    }

    public UserVO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UserVO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public UserVO setNickName(String nickName) {
        this.nickName = nickName;
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
        return "UserVO{" +
                "userId='" + userId + '\'' +
                ", loginAccount='" + loginAccount + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", nickName='" + nickName + '\'' +
                ", remark='" + remark + '\'' +
                ", state=" + state +
                "} " + super.toString();
    }
}
