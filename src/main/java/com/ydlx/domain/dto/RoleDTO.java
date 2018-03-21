package com.ydlx.domain.dto;

/**
 * Created by ydlx on 2017/9/9.
 */
public class RoleDTO extends BaseDTO{
    /**角色ID*/
    private String roleId;

    /**角色编码*/
    private String roleCode;

    /**角色名称*/
    private String roleName;

    /**角色描述*/
    private String roleDesc;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

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

    public RoleDTO(){}

    public RoleDTO(String sysId){
        this.setSysId(sysId);
    }
}
