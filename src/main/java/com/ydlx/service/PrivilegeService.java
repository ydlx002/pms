package com.ydlx.service;

import com.ydlx.domain.dto.PrivilegeDTO;
import com.ydlx.domain.vo.PageResultVO;
import com.ydlx.domain.vo.PrivilegeVO;
import com.ydlx.domain.vo.ResultVO;

/**
 * 用户管理服务接口层
 * 1. 账号/用户的增删改查，保证事务一致性
 * Created by ydlx on 2017/5/3.
 */
public interface PrivilegeService {


    /**
     * 分页获取权限详细信息
     * @param currentPage 当前页码
     * @param pageSize 每页行数
     * @param dto 用户查询条件
     * @return
     */
    PageResultVO<PrivilegeVO> getPrivilegeList(int currentPage, int pageSize, PrivilegeDTO dto);


    /**
     * 新增用户
     * @param dto 用户信息
     * @return
     */
    ResultVO addPrivilege(PrivilegeDTO dto);


    /**
     * 删除权限
     * @param priId
     * @return
     */
    ResultVO deletePrivilege(String priId);


    /**
     * 更新权限信息
     * @param dto
     * @return
     */
    ResultVO updatePrivilege(PrivilegeDTO dto);


}
