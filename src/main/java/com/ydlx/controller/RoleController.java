package com.ydlx.controller;

import com.ydlx.domain.dto.RoleDTO;
import com.ydlx.domain.vo.PageResultVO;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.domain.vo.RoleVO;
import com.ydlx.domain.vo.request.role.AddRoleRequest;
import com.ydlx.domain.vo.request.role.QueryRoleRequest;
import com.ydlx.domain.vo.request.role.UpdateRoleRequest;
import com.ydlx.service.RoleService;
import com.ydlx.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ydlx on 2017/8/12.
 */
@RestController
@RequestMapping(value="/role/{sysId}")
public class RoleController {

    private static final String userId="1";
    private static final String fullName="admin";
    private static final String loginAccount="admin";
    //private static final String sysId ="1";

    @Autowired
    private RoleService roleService;

    @Autowired
    private SysService sysService;


    /***
     * 分页获取角色列表
     * @param sysId
     * @param request
     * @return
     */
    @PostMapping(value = "/getListByPage")
    public PageResultVO<RoleVO> getListByPage(@PathVariable("sysId") String sysId, QueryRoleRequest request){
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setSysId(sysId);
        roleDTO.setRoleCode(request.getRoleCode());
        roleDTO.setRoleName(request.getRoleName());
        roleDTO.setOperatorId(userId);
        return roleService.getRoleList(1,10,roleDTO);
    }

    /**
     * 获取指定系统中的角色列表
     * @param sysId
     * @return
     */
    @PostMapping(value = "/getRoleDict")
    public ResultVO getRoleDict(@PathVariable("sysId") String sysId){
        return roleService.getRoleList(new RoleDTO(sysId));
    }

    /***
     * 添加角色信息
     * @param request
     * @return
     */
    @PostMapping(value = "/add")
    public  ResultVO add(@PathVariable("sysId") String sysId, AddRoleRequest request){
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setSysId(sysId);
        roleDTO.setRoleCode(request.getRoleCode());
        roleDTO.setRoleName(request.getRoleName());
        roleDTO.setRoleDesc(request.getRoleDesc());
        roleDTO.setOperatorId(userId);
        return roleService.addRole(roleDTO);
    }

    /***
     * 更新角色
     * @param request
     * @return
     */
    @PostMapping(value = "/{roleId}/update")
    public  ResultVO update(@PathVariable("roleId") String roleId, UpdateRoleRequest request){
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(roleId);
        roleDTO.setRoleName(request.getRoleName());
        roleDTO.setRoleDesc(request.getRoleDesc());
        roleDTO.setOperatorId(userId);
        return roleService.updateRole(roleDTO);
    }

    /**
     * 删除角色
     * @param roleId 指定ID
     * @return
     */
    @PostMapping(value = "/{roleId}/delete")
    public  ResultVO delete(@PathVariable("roleId") String roleId){
        return roleService.deleteRole(roleId);
    }

}
