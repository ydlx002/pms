package com.ydlx.domain.vo.request.role;

import java.io.Serializable;

/**
 * Created by ydlx on 2017/9/9.
 */
public class UpdateRoleRequest implements Serializable{

    /**角色编码*/
    private String roleCode;

    /**角色名称*/
    private String roleName;

    /**角色描述*/
    private String roleDesc;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
