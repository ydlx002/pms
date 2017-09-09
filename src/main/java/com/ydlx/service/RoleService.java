package com.ydlx.service;

import com.ydlx.domain.dto.RoleDTO;
import com.ydlx.domain.vo.PageResultVO;
import com.ydlx.domain.vo.RoleVO;
import com.ydlx.domain.vo.ResultVO;

/**
 * Created by ydlx on 2017/9/9.
 */
public interface RoleService {
    /**
     * 分页获取权限详细信息
     * @param currentPage 当前页码
     * @param pageSize 每页行数
     * @param dto 用户查询条件
     * @return
     */
    PageResultVO<RoleVO> getRoleList(int currentPage, int pageSize, RoleDTO dto);


    /**
     * 获取权限列表
     * @return
     */
    ResultVO getRoleList(RoleDTO dto);

    /**
     * 新增权限
     * @param dto 权限信息
     * @return
     */
    ResultVO addRole(RoleDTO dto);


    /**
     * 删除权限
     * @param priId
     * @return
     */
    ResultVO deleteRole(String priId);


    /**
     * 更新权限信息
     * @param dto
     * @return
     */
    ResultVO updateRole(RoleDTO dto);
}
