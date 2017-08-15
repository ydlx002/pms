package com.ydlx.constants;

/**
 * 1000  系统错误
 * 2000  用户管理错误
 * 3000  角色管理错误
 * 4000  权限管理错误
 * 5000
 * 9000  参数错误
 * Create by ydlx on 2017/5/3.
 */
public enum ResultType {
    FAIL("9999", "操作失败"),
    SUCCESS("0000", "操作成功"),
    SESSIONTIMEOUT("1001","会话超时"),
    EMPTYPARENTID("1002","父节点菜单ID为空"),
    EFFECTIVEACCOUNT("2001","当前用户当前应用于其他系统，不允许删除"),
    ACCOUNTEXISTS("9001","账号已存在"),
    MOBILEXISTS("9002","手机号已存在"),
    EMAILEXISTS("9003","邮箱已存在"),

    ;

    private String returnCode;

    private String returnDesc;

    ResultType(String returnCode, String returnDesc) {
        this.returnCode = returnCode;
        this.returnDesc = returnDesc;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnDesc() {
        return returnDesc;
    }

    public void setReturnDesc(String returnDesc) {
        this.returnDesc = returnDesc;
    }
}
